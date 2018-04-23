import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList.*;

public class Quiz {

	static JFrame frame;
	static AllQuestions questions = new AllQuestions();
	static Scanner in = new Scanner(System.in);
	static int rightAnswers = 0;
	static int questionNumber = 0;
	static String input;
	

	public static void main(String args[]){
		/*
		Question q1 = new Question("CPU is short for?", new String[] {"Central Processing Unit", "Current Power U","Content Powered Unit", "Core Pi Uvi"}, "A", "computer");
		Question q2 = new Question("Which of the following are components of Central Processing Unit (CPU) ?", new String[] {"Arithmetic logic unit, Mouse","Arithmetic logic unit, Control unit","Arithmetic logic unit, Integrated Circuits", "Control Unit, Monitor"}, "B", "computer");
		Question q3 = new Question("What is a laptop?", new String[] {"toaster","portable computer","mouse","server"},"B","computer");
		Question q4 = new Question("WWW stands for?", new String[] {"World Whole Web","Wide World Web","Web World Wide","World Wide Web"}, "D", "computer");
		Question q5 = new Question("Where is RAM Located", new String[] {"Expansion Board", "External Drive", "Mother Board", "All of the above"}, "C", "computer");
		try {
			FileOutputStream fos = new FileOutputStream("questions.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(q1);
			oos.writeObject(q2);
			oos.writeObject(q3);
			oos.writeObject(q4);
			oos.writeObject(q5);
			oos.close();
		} catch (Exception e){
			System.out.print("Exception: "+e);
		}
		*/
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Welcome to the Quiz system!");
			System.out.println("The topic of this quiz is : " + Topic.getQuizTopic() );
		}
		catch (Exception e) {
			System.out.println("Choose one topic as your quiz topic: ");
			String retuentopic = in.nextLine();
		}

		

		readFile();
		while(true){
			System.out.print(questions.getQuestions()[questionNumber]);
			printQuestion(questions.getQuestions()[questionNumber]);
			CheckAnswer(questions.getQuestions()[questionNumber]);
			nextQuestion(questions.getQuestions()[questionNumber]);
			questionNumber += 1 ;
			if( questionNumber == 4 ) {
				System.out.println("Number of right questions: "+rightAnswers+"\n");
				System.out.println("Number of right questions per question"+rightAnswers+"/"+5);
				break;
			}
		}

	}

	public static void printQuestion (Question obj) {
		System.out.println(obj.getQuestion()+"\n");

		String answer = "A) ";
		for ( int i = 0; i <= 3 ; i++ ) {
			if(i==1){
				answer = "B) ";
			} else if(i==2){
				answer = "C) ";
			} else if(i==3) {
				answer = "D) ";
			}
			System.out.println(answer+obj.getAnswers()[i]+"\n");
		}
		System.out.println("\n Please select one answer.\n");
	}

	public static void printPicture (Question obj) {
		if (obj.getPicture().equals("")) {}
		else {
			frame = new JFrame();
			ImageIcon icon = new ImageIcon("image.png");
			frame.add(new JLabel(icon));
			frame.pack();
			frame.setVisible(true);
		}
	}

	public static void closePicture () {
		if ( frame != null ) {
			frame.dispose();
			frame = null;
		}
	}

	public static void readFile() {
		try {
			FileInputStream fis = new FileInputStream("questions.txt");
			int index = 0;
			ObjectInputStream ois = new ObjectInputStream(fis);
			while(true){
				Question obj = (Question) ois.readObject();
				if ( index < 6 ) {
					questions.setQuestion(obj, index);
					index += 1;
				} else {
					break;
				}
			}
			ois.close();
		} catch (Exception e){
    		 e.printStackTrace();
		}
	}

	public static void CheckAnswer(Question obj) {
		System.out.println("\n Write Restart if you want to restart the quiz \n");
		String input2;
		while(true) {
			input2 = in.nextLine();
			if(input2.matches("(?i)A|B|C|D|RESTART")){
				break;
			} else {
				System.out.println("Please write one letter, or the word restart if you want to restart.\n");
				System.out.println("Type skip to skip this question, ");
			}
		}
		if(input2.equalsIgnoreCase(obj.getRightAnswer())){
			input = obj.getRightAnswer();
		} else {
			input = input2;
		}
	}

	public static void nextQuestion ( Question obj ) {
		boolean restart = false;
		if ( input.equals(obj.getRightAnswer())) {
			System.out.println(obj.getRightAnswer()+" is right!");
			rightAnswers++;
		} else if ( input.equalsIgnoreCase("restart")) {
			questionNumber = -1;
			rightAnswers = 0;
			restart = true;
		} else {		
			System.out.println(input+" is wrong!\n");
			System.out.println("The right asnwer is "+obj.getRightAnswer());
		}
		System.out.println("\nWrite next for the next question.");
		if(restart == false){
			while (true){
				String next = in.nextLine();
				if ( next.matches("(?i)NEXT")){
					break;
				} else {
					System.out.println("\nPlease write next to continue.\n");
				}
			}
		}
	}
}