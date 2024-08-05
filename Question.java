
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String questionText;
    List<String> options;
    String correctOption;

    public Question(String questionText, List<String> options, String correctOption) {
        this.questionText = questionText;
        this.options = options;
        this.correctOption = correctOption;
    }
}

