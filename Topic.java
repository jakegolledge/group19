import java.util.*;
import java.io.*;

public class Topic {

	//list of topics
	private static ArrayList<Topic> topicList = new ArrayList<Topic>();

    //selected topic
    private static Topic quizTopic = null;

    //topic name variables
    private String topicName;


    //constructor
    public Topic(String topicName) {
    	this.topicName = topicName;
    }

    public static void topicMenu(){
        try (BufferedReader topicReader = new BufferedReader(new FileReader("topic.txt"))){
            String topicLine;
            while((topicLine = topicReader.readLine()) != null){
                String[] topicLS = topicLine.split(",");  
                for (int x = 0; x < topicLS.length; x++){
                    newTopic(topicLS[x]);
                }
            }
        }
        catch (Exception e){
                    System.out.println(e);
        }

        boolean a = true;
        Scanner in = new Scanner(System.in);
        while (a){
            System.out.println("Topic menu - enter a number: \n 1. Choose a topic. \n 2. Add a new topic. \n 3. Delete a topic. \n 4. Return to quiz.");
            String topicChoice = in.nextLine();
            if (topicChoice.equals("1")){
                if (topicList.size() != 0){
                    System.out.println("Enter the number of the topic you wish to select: ");
                    for(int i = 0; i <  topicList.size(); i++){
                        System.out.println((i+1) + ". " + topicList.get(i));
                        }
                    int returnTopic = in.nextInt();
                    returnTopic -=1;
                    chooseTopic(returnTopic);
                }else{
                    System.out.println("No topics exist, please add a new topic.");
                }
            }
            if (topicChoice.equals("2")){
                System.out.println("Enter the name of the topic you wish to create:");
                String topicCreate = in.nextLine();
                newTopic(topicCreate);
            }
            if (topicChoice.equals("3")){
                if (topicList.size() != 0){
                    System.out.println("Type the number of the topic you wish to delete: ");
                    for(int j = 0; j <  topicList.size(); j++){
                        System.out.println((j+1) + ". " + topicList.get(j));
                        }
                    int topicDelete = in.nextInt();
                    topicDelete -=1;
                    deleteTopic(topicDelete);
                }else{
                    System.out.println("No topics exist, please add a new topic:");
                }
            }
            if (topicChoice.equals("4")){
                try{
                    PrintWriter write = new PrintWriter("topic.txt");
                    for (Topic line: topicList){
                        write.print(line + ",");
                    }
                    write.close();
                    a = false;
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }

    public static ArrayList<Topic> getTopicList() {
    	return topicList;
    }

    public static Topic getQuizTopic() {
    	return quizTopic;
    }

    public static void newTopic(String userAdd){
        topicList.add(new Topic(userAdd));
    }

    //delete
    public static void deleteTopic(int userDelete) {
    	topicList.remove(userDelete);
    }

    //choose
    public static void chooseTopic(int userChoose) {
    	quizTopic = (topicList.get(userChoose));
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



 

