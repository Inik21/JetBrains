public class Main {
    public static void main(String[] args) {
        // The hours the student has to study
        final int hoursToStudy = 6;
        // The number of topics the student has to study
        final int topicsToStudy = 3;
        // All the times that it will take the student to learn each topic. They start from 1 for convenience
        final int[] timesForTopics = {0,3,2,1};
        // All the questions that can be on the exam for each topic. They start from 1 for convenience
        final int[] questionsForTopics = {0,12,1,5};

        // Return the maximum number of questions we can learn for the exam for the time we have
        int maximumNumberOfQuestionsLearned = prepareForExam(hoursToStudy, topicsToStudy, timesForTopics, questionsForTopics);

        System.out.println(maximumNumberOfQuestionsLearned);
    }

    public static int prepareForExam(int hoursToStudy, int topics, int[] times, int[] questionsOnExam) {
        // A matrix to keep track of the maximum number of questions for each hour and each topic
        int[][] memory = new int[hoursToStudy+1][topics+1];

        // Initialize the values where we have zero hours to learn or zero topics to learn to zero
        for (int i = 0; i<=topics; i++) {
            memory[0][i] = 0;
        }

        for (int i = 0; i<=hoursToStudy; i++) {
            memory[i][0] = 0;
        }

        // For each next hour and topic find the maximum number of questions we can learn
        for(int i = 1; i<=hoursToStudy; i++) {
            for(int j = 1; j<=topics;j++) {
                int notPicked = memory[i][j-1];
                int picked = 0;
                if(i-times[j]>=0) {
                    picked = memory[i-times[j]][j-1] + questionsOnExam[j];
                }
                memory[i][j] = Math.max(notPicked,picked);
            }
        }

        return memory[hoursToStudy][topics];
    }
}