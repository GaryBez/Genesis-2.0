package application;

import java.io.IOException;

public class InputPCAPheno {
	
	public int importPheno(String path, PCASubject[] pcaData) throws IOException {
		ReadInputFile rf = new ReadInputFile();
		String[] input = rf.readFileWithoutComments(path);
		if(input == null) {
			return -1;
		}
		convertEvec2Phenofile(input);
		int check=fillPheno(pcaData, input);
		return check;
	}

	private void convertEvec2Phenofile(String[] input) {
		if(input[0].contains(":")) {
			for(int i=0;i<input.length;i++) {
				String s = input[i];
				String[] strings = s.split(":");
				input[i] = joinStrings(strings);
			}
		}	
	}

	private String joinStrings(String[] strings) {
		StringBuilder sb = new StringBuilder();
		for(String s:strings) {
			sb.append(s+" ");
		}
		return sb.toString().trim();
	}

	private int fillPheno(PCASubject[] pcaData, String[] input) {
		String[][] phenos = new String[pcaData.length][];
		int count = 0;
		for(String s:input) {
			String[] data = s.split("\\s+|:");
			int pos = search(pcaData,data[0]+" "+data[1]);
			if(pos>-1) {
				phenos[pos] = (data);
				count++;
			}
			else {
				
			}
		}
		if(count>0) {
			clearPheno(pcaData);
			for(int i=0;i<phenos.length;i++) {
				pcaData[i].setPhenoData(phenos[i]);
			}
		}
		return count;
	}

	private void clearPheno(PCASubject[] pcaData) {
		for(PCASubject p:pcaData) {
			p.setPhenoData(null);
		}
	}

	private int search(PCASubject[] pcaData, String name) {
		for(int i=0;i<pcaData.length;i++) {
			if(name.equals(pcaData[i].getName())) {
				return i;
			}
		}
		return -1;
	}

}
