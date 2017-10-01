package myquiz;

public class Question implements java.io.Serializable {

	private static final long serialVersionUID = -4742275006845148324L;
	String question = "act";
    String answer = "cat";
    Integer rating = 100;
    Integer age = 0;
    String flags = "";
    String note = "";
    Boolean unseen = false;
    
    public Question(String question, String answer) {
    	this.question = question;
    	this.answer = answer;
    }
    public Question(String line) {
        String[] fields = line.split("\t", 100);
        this.question = fields[0];
        this.answer = fields[1];
        if (fields[2].charAt(0) == '+'){
        	unseen = true;
        }
        this.rating = Integer.parseInt(fields[2]);
        this.age = Integer.parseInt(fields[3]);
        this.flags = fields[4];
        this.note = fields[5];
    }

    public int updateAsCorrect(int secondsTookToAnswer) {
    	rating = unseen? secondsTookToAnswer : (int)((1 + 2 * rating + secondsTookToAnswer) / 3.0);
    	updateAgeAndSeen();
    	return rating;
    }
    
    public int updateAsIncorrect() {
    	rating = 100;
    	updateAgeAndSeen();
    	return rating;
    }
    
    private void updateAgeAndSeen() {
    	age = (int)(System.currentTimeMillis() / 1000);
    	unseen = false;
    }
    

//  start of Setters and getters, no real code below here
    
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getFlags() {
        return flags;
    }
    public void setFlags(String flags) {
        this.flags = flags;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public Boolean getUnseen() {
    	return unseen;
    }
    public void setUnseen(Boolean unseen) {
    	this.unseen = unseen;
    }
    
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(question);
    	sb.append('\t');
    	sb.append(answer);
    	sb.append('\t');
    	sb.append(rating);
    	sb.append('\t');
    	sb.append(age);
    	sb.append('\t');
    	sb.append(flags);
    	sb.append('\t');
    	sb.append(note);
    	return sb.toString();
    }
    //  end of Setters and getters
    // please put your real code above these setters/getters
}
