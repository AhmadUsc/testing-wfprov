package sparql;

/**
 * 
 * @author agarrido
**/


public class Queries {
	private String prefix= "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
			"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "+
			"PREFIX  wfprov: <http://purl.org/wf4ever/wfprov#> "+
			"PREFIX  wfdesc: <http://purl.org/wf4ever/wfdesc#> ";	
	
	//private String instanceDescribedByProcess = prefix+"SELECT ?instance ?process WHERE " +
	//		"{?instance wfprov:describedByProcess ?process}";
	//public String getInstanceDescribedByProcess() {
	//	return instanceDescribedByProcess;
	//}
	
	
	
	public String getProcesos(){
		return prefix+"SELECT DISTINCT ?process WHERE {?process ?b wfprov:Process}";
	}

	public String getInputs(String name) {
		return prefix+"SELECT ?input WHERE {<"+name+">  wfprov:usedInput ?input}";
	}
	
	public String getOutputs(String name) {
		return prefix+"SELECT ?output WHERE {?output wfprov:wasOutputFrom <"+name+">}";
	}
	
	public String getExecutedProcesses(String name){
		return prefix + "SELECT DISTINCT ?process WHERE {?process wfprov:wasPartOfWorkflowRun <"+name+">}";
	}

	public String getTemplate(String name) {
		return prefix + "Select ?template where {<"+name+"> wfprov:describedByProcess ?template}";
	}

	public String getListExecutions() {
		return prefix + "SELECT ?wfRun WHERE {?wfRun a wfprov:WorkflowRun}";
	}
	

	
	public String getIOs(String name) {
		return prefix + "Select DISTINCT ?input ?output where { " +
				"{?output wfprov:wasOutputFrom ?process. ?process wfprov:wasPartOfWorkflowRun <"+name+">} " +
				"UNION " +
				"{?process wfprov:usedInput ?input. ?process wfprov:wasPartOfWorkflowRun <"+name+">}}";
	}

	public String getRunsOfATemplate(String name) {
		return prefix + "Select DISTINCT ?wfRun ?wf where { ?wfRun wfprov:describedByWorkflow ?wf. " +
				"?wf wfdesc:hasProcess <"+name+">}";
		}
	
	public String getUsesOfAnInput(String name) {
		return prefix + "Select DISTINCT ?wfRun ?process where { ?process wfprov:usedInput <"+name+">. " +
				"?process wfprov:wasPartOfWorkflowRun ?wfRun}";
	}
	
	


	
	

}
