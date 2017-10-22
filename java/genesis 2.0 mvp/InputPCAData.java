package application;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputPCAData {
	
	public boolean eigenFile;
	
	public PCASubject[] readPCAInput(String path) throws IOException {
		try {
			ReadInputFile rf = new ReadInputFile();
			String[] input = rf.readFileWithoutComments(path);
			if(input==null) {
				return null;
			}
			input = getPlink(path,input);
			if(isRelInput(input)) {
				eigenFile=false;
				return(InputRelData.relInputToSubjectArray(input));
			};
			eigenFile=true;
			return(InputEigenData.eigenInputToSubjectArray(input));
		}
		catch(NumberFormatException e) {
			return errorPCA(-300);
		}
		catch(ArrayIndexOutOfBoundsException e){
			return errorPCA(-400);
		}
	} 

	public static PCASubject[] errorPCA(int errorCode) {
		PCASubject[] result = new PCASubject[1];
		float[] cols = new float[1];
		cols[0] = errorCode;
		result[0] = new PCASubject(cols,"error");
		return result;
	}

	private boolean isRelInput(String[] input) {
		return (input[0].equals("x"));
	}

	private String[] getPlink(String path, String[] input) throws IOException {
		ReadInputFile rf = new ReadInputFile();
		String famfname, pheno, fam[];
		Pattern epat, fpat;
		Matcher m;
		
		if(!(path.endsWith(".eigenvec")))
			return input;
		famfname = path.replaceFirst(".eigenvce", ".fam");
		File f = new File(famfname);
		if(!(f.exists()))
			return input;
		if(input[1].indexOf(":") != -1)
			return input;
		
		fam = rf.readFileWithoutComments(famfname);
		epat = Pattern.compile("^\\s*(\\S+)\\s+(\\S+)(.*)");
		fpat = Pattern.compile("^.*\\s(\\S+)");
		for(int i=0;i<input.length;i++) {
			m = fpat.matcher(fam[i]);
			if(!(m.find())) {
				System.out.println("Un grande probleme");
				System.out.println(input[i]);
					InputPCAData.errorPCA(-102);
			}
			pheno = m.group(1);
			m = epat.matcher(input[i]);
			if (!(m.find())) {
				System.out.println("Un grande probleme");
				System.out.println(input[i]);
					InputPCAData.errorPCA(-103);
			}
			input[i] = " " + m.group(1) + ":" + m.group(2) + " " + m.group(3) + "\t" + pheno;
		}
		return input;
	}

}
