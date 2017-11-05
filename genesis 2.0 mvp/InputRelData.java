package application;

public class InputRelData {

	public static PCASubject[] relInputToSubjectArray(String[] input) throws NumberFormatException{
			int lineNo=getFirstImportantLine(input);
			
			int noComponents = input[lineNo].trim().split("\\s+|\\t+").length-3;
			if(noComponents<1) {
				return InputPCAData.errorPCA(-150);
			}
			else {
				return createDataFromRelInput(input, lineNo, noComponents);
			}
		}

	private static PCASubject[] createDataFromRelInput(String[] input, int lineNo, int noComponents) {
		PCASubject[] result = new PCASubject[input.length-(lineNo)];
		
		for(int i=lineNo;i<input.length;i++) {
			String[] split = input[i].trim().split("\\s+|:");
			String name = extractName(split);
			float[] ratio = conv(split);
			if(ratio.length!=noComponents) {
				return InputPCAData.errorPCA(-250);
			}
			PCASubject subj=new PCASubject(ratio,name);
			
			subj.setPhenoData(new String[] {name,"",split[2]});
			result[i-lineNo]=subj;
		}
		return result;
	}

	private static String extractName(String[] input) {
		String[] nameArr = input[1].split("-");
		String name;
		if(nameArr.length==1) {
			name=nameArr[0]+" "+nameArr[0];
		}
		else {
			name=nameArr[0]+" "+nameArr[1];
		}
		return name;
	}

	private static float[] conv(String[] line) throws NumberFormatException{
		float[] result = new float[line.length-3];
		for(int i=3;i<line.length;i++) {
			result[i-1]=Float.parseFloat(line[i].trim());
		}
		return result;
	}

	private static int getFirstImportantLine(String[] input) {
		int lineNo=0;
		
		while(true) {
			if(input[lineNo].charAt(0)=='s') {
				lineNo++;
				break;
			}
			lineNo++;
		}
		return lineNo;
	}

}
