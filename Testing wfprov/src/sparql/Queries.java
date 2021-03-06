package sparql;

/**
 * 
 * @author agarrido
**/


public class Queries {
	private String prefix= "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
			"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "+
			"PREFIX  wfprov: <http://purl.org/wf4ever/wfprov#> ";	
	
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


	
	

}
