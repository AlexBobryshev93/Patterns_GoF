public class Main {
    public static void main(String[] args) {
        Developer developer = new JuniorDeveloper();
        developer.doJob(); // junior dev

        developer = new SeniorDeveloper(developer);
        developer.doJob(); // junior dev + senior dev

        developer = new TeamLead(developer);
        developer.doJob(); // junior dev + senior dev + teamlead
    }
}

interface Developer {
    void doJob();
}

class JuniorDeveloper implements Developer {
    @Override
    public void doJob() {
        System.out.println("Writing code...");
    }
}

abstract class DeveloperDecorator implements Developer {
    Developer developer;

    public DeveloperDecorator(Developer developer) {
        this.developer = developer;
    }

    @Override
    public void doJob() {
        developer.doJob();
    }
}

class SeniorDeveloper extends DeveloperDecorator{
    public SeniorDeveloper(Developer developer) {
        super(developer);
    }

    public void makeCodeReview() {
        System.out.println("Making code review...");
    }

    @Override
    public void doJob() {
        super.doJob();
        makeCodeReview();
    }
}

class TeamLead extends DeveloperDecorator { // concrete Decorator class
    public TeamLead(Developer developer) {
        super(developer);
    }

    public void makeReport() {
        System.out.println("Making a weekly report...");
    }

    @Override
    public void doJob() {
        super.doJob();
        makeReport();
    }
}
