package org.muveo.android.googlURLShortener;

public class TestHarness {

	public static void main(String[] args) {
		GooglURLInsert myShortener = new GooglURLInsert();
		myShortener.setLongURL("https://plus.google.com/u/1/106063116421909062144/");
		myShortener.setApiKey("AIzaSyB0ahjhM8yRa8HPqHVgtriQv3PQdxcLmQg");
//		try {
//			System.out.println("Generated URL: " + myShortener.send());
//		} catch (GooglURLShortenerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
