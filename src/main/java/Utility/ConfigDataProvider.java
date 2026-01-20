package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	static Properties pro;

	public ConfigDataProvider() throws IOException {

		String path = ".\\ConfigData\\Configdata";

		FileInputStream file = new FileInputStream(path);

		pro = new Properties();
		pro.load(file);
	}

	public String GetBaseUrl_01() {

		return pro.getProperty("BaseUrl_QA1");
	}

	public String GetBaseUrl_02() {

		return pro.getProperty("BaseUrl_QA2");
	}
	
	public String GetBaseUrl_03() {

		return pro.getProperty("BaseUrl_QA3");
	}
}
