package application;

public class InputEigenData {

	public static PCASubject[] eigenInputToSubjectArray(String[] input) throws NumberFormatException{
		int noComponents = input[0].trim().split("\\s+|\\t+").length-2;				
		if(noComponents<1){
			return InputPCAData.errorPCA(-100);
		}else{
			return createDataFromEigenInput(input, noComponents);
		}
		
	}

	private static PCASubject[] createDataFromEigenInput(String[] input, int noComponents) throws NumberFormatException{
		PCASubject[] result = new PCASubject[input.length];
		for(int i=0;i<input.length;i++){
			String[] split = input[i].trim().split("\\s+");
			String name = extractName(split);				
			float[] ratio = conv(split);

			if(ratio.length!=noComponents){
				return InputPCAData.errorPCA(-200);
				
			}
			result[i]=new PCASubject(ratio,name);
		}

		return result;
		
	}
	

	private static String extractName(String[] input) {
		String[] nameArr = input[0].split(":");
		String name;
		if(nameArr.length==1){
			name=nameArr[0]+" "+nameArr[0];
		}else{
			name=nameArr[0]+" "+nameArr[1];
		}
		return name;
	}

	private static float[] conv(String[] split)throws NumberFormatException{	
		float[] result = new float[split.length-2];
		for(int i=1;i<split.length-1;i++){
			result[i-1]=Float.parseFloat(split[i].trim());
		}
		return result;

	}

}
