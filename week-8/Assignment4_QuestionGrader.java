import java.util.Scanner;

abstract class Question {

    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(String questionText, String correctAnswer,
             String studentAnswer, double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double calculateScore();

    abstract String getType();
}

class MCQQuestion extends Question {

    MCQQuestion(String questionText, String correctAnswer,
                String studentAnswer, double points) {

        super(questionText, correctAnswer,
              studentAnswer, points);
    }

    double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    String getType() {
        return "MCQ";
    }
}

class TFQuestion extends Question {

    TFQuestion(String questionText, String correctAnswer,
               String studentAnswer, double points) {

        super(questionText, correctAnswer,
              studentAnswer, points);
    }

    double calculateScore() {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {

    EssayQuestion(String questionText, String correctAnswer,
                  String studentAnswer, double points) {

        super(questionText, correctAnswer,
              studentAnswer, points);
    }

    double calculateScore() {

        String answer =
                studentAnswer.toLowerCase();

        String[] keywords =
                correctAnswer.split(",");

        int count = 0;

        for (String keyword : keywords) {

            keyword = keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        }
        else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }

    String getType() {
        return "ESSAY";
    }
}

public class Assignment4_QuestionGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Question[] questions = new Question[n];

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts =
                    line.split("\"");

            String type =
                    parts[0].trim();

            String questionText =
                    parts[1];

            String correctAnswer =
                    parts[3];

            String studentAnswer =
                    parts[5];

            double points =
                    Double.parseDouble(parts[6].trim());

            if (type.equals("MCQ")) {

                questions[i] =
                        new MCQQuestion(
                                questionText,
                                correctAnswer,
                                studentAnswer,
                                points);
            }
            else if (type.equals("TF")) {

                questions[i] =
                        new TFQuestion(
                                questionText,
                                correctAnswer,
                                studentAnswer,
                                points);
            }
            else {

                questions[i] =
                        new EssayQuestion(
                                questionText,
                                correctAnswer,
                                studentAnswer,
                                points);
            }
        }

        double total = 0;

        for (Question question : questions) {

            double score =
                    question.calculateScore();

            System.out.printf("%s: %.2f%n",
                    question.getType(), score);

            total += score;
        }

        System.out.printf(
                "Total Score: %.2f%n", total);

        sc.close();
    }
}
