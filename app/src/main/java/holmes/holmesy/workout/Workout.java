package holmes.holmesy.workout;

public class Workout {
    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("The limb loosener", "50 handstands\n20 squats"),
            new Workout("Core Agony", "100 push ups\n100 sit ups")
    };


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.name;
    }

    private Workout(String name, String description){
        this.name = name;
        this.description = description;
    }



}
