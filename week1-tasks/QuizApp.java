import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class QuizApp {
    private static List<Quiz> quizzes = new ArrayList<>();

    public static void createQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter quiz title: ");
        String title = scanner.nextLine();
        quizzes.add(new Quiz(title));
        System.out.println("Quiz '" + title + "' created.");
    }

    public static void addQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter quiz title to add question to: ");
        String title = scanner.nextLine();
        Quiz quiz = findQuizByTitle(title);
        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;
        }
        System.out.print("Enter question: ");
        String questionText = scanner.nextLine();
        List<String> options = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            System.out.print("Enter option " + i + ": ");
            options.add(scanner.nextLine());
        }
        System.out.print("Enter correct option: ");
        String correctOption = scanner.nextLine();
        quiz.addQuestion(new Question(questionText, options, correctOption));
        System.out.println("Question added.");
    }

    public static void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter quiz title to take: ");
        String title = scanner.nextLine();
        Quiz quiz = findQuizByTitle(title);
        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;
        }
        int score = quiz.takeQuiz();
        quiz.showResults(score);
    }

    public static Quiz findQuizByTitle(String title) {
        for (Quiz quiz : quizzes) {
            if (quiz.title.equalsIgnoreCase(title)) {
                return quiz;
            }
        }
        return null;
    }

    public static void showHelp() {
        System.out.println("""
            Available commands:
            1. createQuiz - Create a new quiz.
            2. addQuestion - Add a question to a quiz.
            3. takeQuiz - Take a quiz.
            4. help - Show available commands.
        """);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command (type 'help' for available commands): ");
            String command = scanner.nextLine().trim();
            switch (command) {
                case "createQuiz" -> createQuiz();
                case "addQuestion" -> addQuestion();
                case "takeQuiz" -> takeQuiz();
                case "help" -> showHelp();
                default -> System.out.println("Unknown command. Type 'help' for available commands.");
            }
        }
    }
}