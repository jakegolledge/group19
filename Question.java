import java.io.*;

public class Question implements Serializable {

	private String question;
	private String rightAnswer;
	private String[] answers;
	private Boolean hasPicture;
	private String pictureName;
	private String topic;


	public Question(String question, String[] answers, String rightAnswer, String topic) {
		this.question = question;
		this.answers = answers;
		this.rightAnswer = rightAnswer;
		this.topic = topic;
	}

	public Question(String question, String[] answers, String rightAnswer, String topic, String pictureName) {
		this.question = question;
		this.answers = answers;
		this.rightAnswer = rightAnswer;
		this.pictureName = pictureName;
		this.topic = topic;
	}

	public String getQuestion() {
		return question;
	}

	public String[] getAnswers() {
		return answers;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public String getPicture() {
		if ( pictureName != null ) {
			return pictureName;
		}
		return "";
	}

	public String getTopic() {
		return topic;
	}
}