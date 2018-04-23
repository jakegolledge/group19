import java.util.ArrayList;

public class Topic {

	//list of topics
	private static ArrayList<Topic> topicList = new ArrayList<>(); 

    //selected topic
    private static Topic quizTopic = null;

    //topic name variables
    private String topicName;


    //constructor
    public Topic(String topicName) {
    	this.topicName = topicName;
    	Topic.topicList.add(this);
    }

    public static ArrayList<Topic> getTopicList() {
    	return topicList;
    }

    public static Theme getQuizTopic() {
    	return quizTopic;
    }


    //delete
    public static void deleteTopic(String userChoose) {
    	quizTopic.remove(Integer.parseInt(userDelete));
    }

    //choose
    public static void chooseTopic(String userChoose) {
    	quizTopic = (topicList.get(Integer.parseInt(userChoose)));
    }

    //get topic
    public String getTopic()
    {
    	return this.topicName;
    }

    @Override
    public String toString() {
    	return (this.topicName);
    }
}



 

