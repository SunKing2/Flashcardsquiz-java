package makerelease;

public class RequestResponseToHtml {

	public static void main(String[] args) {
		RequestResponseToHtml tool = new RequestResponseToHtml();

		String[] reqs = {
				"http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&command=start",
				"http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&userResponse=taq",
				"http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&userResponse=car",
				"http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&userResponse=xxx",
				"http://localhost:8080/Flashcardquiz-java/do?type=json&app=quiz&userResponse=cow",
		};
		
		String sReturn = "";
		for (String sURL : reqs) {
			sReturn += tool.lineToTable(sURL);
		}
		System.out.println(sReturn);
	}

	private String lineToTable(String sURL) {
		String sReturn = "";
		sReturn += "<table border='1'>\n";
		String[] lines = extractQueryString(sURL);
		
		String[] fields = null;
		for (String line: lines) {
			sReturn +="  <tr>\n";
			fields = line.split("=");
			sReturn += "    <td>";
			sReturn += (fields[0]);
			sReturn += ("</td><td>");
			sReturn += (fields[1]);
			sReturn += "</td>";
			sReturn += ("\n  </tr>\n");
		}
		sReturn += ("</table>\n");
		return sReturn;
	}

	private String[] extractQueryString(String sURL) {
		int q = sURL.indexOf('?');
		String sQuery = sURL.substring(q + 1);
		return sQuery.split("&");
	}
}
