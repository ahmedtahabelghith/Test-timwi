package com.timwi;



    class Reindeer {
        private final String name;
        private final int speed; // in km/s
        private final int runTime; // in s
        private final int restTime; // in s

        public Reindeer(String name, int speed, int runTime, int restTime) {
            this.name = name;
            this.speed = speed;
            this.runTime = runTime;
            this.restTime = restTime;
        }

        // Get the name of the reindeer.
        public String getName() {
            return name;
        }

        // Calculate the distance the reindeer travels for the given time.
        public int distanceForTime(int seconds) {
            int intervals = seconds / (runTime + restTime);
            return speed * runTime * intervals + Math.min(seconds % (runTime + restTime), runTime) * speed;
        }

        // Calculate the time traveled for the given distance.
        public int timeForDistance(int km) {
            return (km / speed) * (runTime + restTime) / runTime;
        }
        
    }


   

   