import java.util.*;

public class QuizApplication {
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static int questionIndex = 0;
    private static Timer timer;

    private static Map<String, List<String>> questionsWithOptions = new HashMap<>();
    private static Map<String, String> correctAnswers = new HashMap<>();
    private static List<String> correctAnswersSummary = new ArrayList<>();

    public static void main(String[] args) {
        initializeQuestions();
        startQuiz();
    }

    private static void initializeQuestions() {
        // Store quiz questions along with multiple-choice options and correct answers
        questionsWithOptions.put("What is the capital of France?",
                Arrays.asList("A. London", "B. Paris", "C. Rome", "D. Madrid"));
        correctAnswers.put("What is the capital of France?", "B");

        questionsWithOptions.put("Which planet is known as the Red Planet?",
                Arrays.asList("A. Venus", "B. Mars", "C. Jupiter", "D. Saturn"));
        correctAnswers.put("Which planet is known as the Red Planet?", "B");

        questionsWithOptions.put("Who wrote 'Romeo and Juliet'?",
                Arrays.asList("A. William Shakespeare", "B. Charles Dickens", "C. Jane Austen", "D. Mark Twain"));
        correctAnswers.put("Who wrote 'Romeo and Juliet'?", "A");
    }

    private static void startQuiz() {
        System.out.println("Welcome to the Quiz Application!");

        for (String question : questionsWithOptions.keySet()) {
            askQuestion(question);
        }

        System.out.println("\nQuiz ended!");
        System.out.println("Your score: " + score + "/" + questionsWithOptions.size());
        if (correctAnswersSummary.size() > 0) {
            System.out.println("Summary of correct answers:");
            for (String answer : correctAnswersSummary) {
                System.out.println(answer);
            }
        }
        scanner.close();
    }

    private static void askQuestion(String question) {
        System.out.println("\nQuestion: " + question);
        List<String> options = questionsWithOptions.get(question);
        for (String option : options) {
            System.out.println(option);
        }

        System.out.print("Enter your answer (A, B, C, or D): ");
        String userAnswer = scanner.next().toUpperCase();

        if (userAnswer.equals(correctAnswers.get(question))) {
            System.out.println("Correct!");
            score++;
            correctAnswersSummary.add("Question: " + question + " - Correct Answer: " + userAnswer);
        } else {
            System.out.println("Incorrect!");
        }
    }
}
