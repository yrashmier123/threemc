package com.threemc.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.threemc.data.Log;
import com.threemc.model.DatabaseLogs;

public class AddLog {
	private static final int USER_ID = 10001;
	private static DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss MM/dd/yyyy");
	public static void addLog(String title, String desc) {
		Log log = new Log(USER_ID, title, desc , (String) dateFormat.format(System.currentTimeMillis()));
		try {
			if(DatabaseLogs.connect().equals("ok")) {
				DatabaseLogs.saveLog(log);
			} else {
				System.out.println(DatabaseLogs.connect());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
