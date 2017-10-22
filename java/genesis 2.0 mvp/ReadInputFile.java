package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ReadInputFile {
	
	public String[] readInputFile(String path) throws IOException {
		File f = new File(path);
		if(!f.exists()) {
			return null;
		}
		else {
			String[] a;
			this.setPath(path);
			a = this.OpenFile();
			return a;
		}
	}
	
	public String[] readFileWithoutComments(String path) throws IOException {
		if(path==null) {
			return null;
			
		}
		File f = new File(path);
		if(!f.exists()) {
			return null;
		}
		else {
			String[] a;
			this.setPath(path);
			a = this.OpenFileWithoutComments();
			return a;
		}
	}
	
	public String[] readFileWithEmpty(String path) throws IOException {
		if(path==null) {
			return null;
		}
		File f = new File(path);
		if(!f.exists()) {
			return null;
		}
		else {
			String[] a;
			this.setPath(path);
			a = this.OpenFileWithEmpty();
			return a;
		}
	} 

	private String[] OpenFileWithEmpty() throws IOException {
		LinkedList<String> LL = new LinkedList<String>();
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String next;
		while((next=br.readLine())!=null) {
			LL.add(next);
		}
		br.close();
		return LLtoArray(LL);
	}

	private String[] OpenFileWithoutComments() throws IOException{
		LinkedList<String> LL = new LinkedList<String>();
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String next;
		boolean first = false;
		while((next=br.readLine())!=null) {
			if(!first) {
				first = true;
			}
			try {
				if(!next.equals("")&&(!(next.trim().charAt(0)=='#'))){
					LL.add(next);
				}
			}
			catch(StringIndexOutOfBoundsException e){
			}	
		}
		br.close();
		return LLtoArray(LL);
	}
	
	private String path;
	private void setPath(String file_path) {
		path = file_path;	
	}

	private String[] OpenFile() throws IOException{
		LinkedList<String> LL = new LinkedList<String>();
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		String next;
		while((next=br.readLine())!=null) {
			if(!next.equals("")) {
				LL.add(next);
			}
		}
		br.close();
		return LLtoArray(LL);
	}

	private String[] LLtoArray(LinkedList<String> LL) {
		String[] result = new String[LL.size()];
		for(int i=0;i<LL.size();i++) {
			result[i]=LL.get(i);
		}
		return result;
	}
}
