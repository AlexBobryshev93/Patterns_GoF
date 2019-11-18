public class Main {
    public static void main(String[] args) {
        DeveloperTrainer developerTrainer = new JavaDeveloperTrainer();
        developerTrainer.train();
        developerTrainer = new FrontendDeveloperTrainer();
        developerTrainer.train();
    }
}

abstract class DeveloperTrainer {
    public final void train() { // Template method
        learnSchoolMathematics();
        learnProgrammingLanguageCore();
        learnFrameworks();
        endLearning();
        System.out.println();
    }

    void learnSchoolMathematics() { // Default method
        System.out.println("Learning school maths...");
    }

    abstract void learnProgrammingLanguageCore(); // Must be overridden

    void learnFrameworks() { // Hook method, can be overridden, however it's optional
    }

    abstract void endLearning(); // Must be overridden
}

class JavaDeveloperTrainer extends DeveloperTrainer {
    @Override
    void learnProgrammingLanguageCore() {
        System.out.println("Learning Java...");
    }

    @Override
    void learnFrameworks() {
        System.out.println("Learning Spring and Hibernate...");
    }

    @Override
    void endLearning() {
        System.out.println("One more Java developer was trained");
    }
}

class FrontendDeveloperTrainer extends DeveloperTrainer {
    @Override
    void learnProgrammingLanguageCore() {
        System.out.println("Learning HTML, CSS and JavaScript...");
    }

    @Override
    void endLearning() {
        System.out.println("One more Frontend developer was trained");
    }
}
