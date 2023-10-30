import java.util.*;

public class QuizApplication {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", Arrays.asList("A. Paris", "B. Rome", "C. Madrid", "D. London"), "A"));
        questions.add(new Question("Which planet is known as the Red Planet?", Arrays.asList("A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"), "B"));
        // Add more questions here

        int totalTime = 60; // Total time for the quiz in seconds
        int score = 0;
        int correctAnswers = 0;
        int incorrectAnswers = 0;

        Timer timer = new Timer();
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestion());
            for (String option : question.getOptions()) {
                System.out.println(option);
            }

            System.out.print("Your answer (A/B/C/D): ");
            String userAnswer = scanner.nextLine().toUpperCase();

            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("Time's up!");
                    timer.cancel();
                }
            };

            timer.schedule(task, totalTime * 1000);

            try {
                String correctAnswer = question.getCorrectAnswer();
                if (userAnswer.equals(correctAnswer)) {
                    System.out.println("Correct!");
                    score++;
                    correctAnswers++;
                } else {
                    System.out.println("Incorrect! The correct answer was " + correctAnswer);
                    incorrectAnswers++;
                }
            } catch (Exception e) {
                System.out.println("Invalid choice");
            }
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + " out of " + questions.size());
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.println("Incorrect Answers: " + incorrectAnswers);
    }
}

class Question {
    private String question;
    private List<String> options;
    private String correctAnswer;

    public Question(String question, List<String> options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
