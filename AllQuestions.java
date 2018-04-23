public class AllQuestions {

	Question[] allQuestions;

	public AllQuestions() {
		allQuestions = new Question[5];
	}

	public Question[] getQuestions() {
		return allQuestions;
	}

	public void setQuestion (Question obj, int index) {
		allQuestions[index] = obj;
	}
}