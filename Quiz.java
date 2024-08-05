import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;




class Quiz {
    String title;
    List<Question> questions;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public int takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.questionText);
            for (int j = 0; j < q.options.size(); j++) {
                System.out.println((j + 1) + ". " + q.options.get(j));
            }
            System.out.print("Your answer: ");
            int answer = scanner.nextInt() - 1;
            if (q.options.get(answer).equals(q.correctOption)) {
                score++;
            }
        }
        return score;
    }

    public void showResults(int score) {
        int totalQuestions = questions.size();
        System.out.println("\nYou scored " + score + " out of " + totalQuestions + ".");
        String feedback = score >= totalQuestions * 0.8 ? "Excellent" : score >= totalQuestions * 0.5 ? "Good" : "Needs Improvement";
        System.out.println("Feedback: " + feedback);
    }
}
