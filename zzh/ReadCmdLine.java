package cn.zzh;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCmdLine {
	public static void read() {
		Process process = null;
		List<String> processList = new ArrayList<String>();
		try {
			process = Runtime.getRuntime().exec("java -jar F:\\VC\\image\\Client.jar");
			BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String line : processList) {
			System.out.println(line);
		}
	}
}
