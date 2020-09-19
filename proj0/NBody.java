public class NBody {
    private static String bgImg = "images/starfield.jpg";

    public static double readRadius(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int N = in.readInt();
        double R = in.readDouble();
        Planet[] planets = new Planet[N];
        /* Keep looking until the file is empty. */
        int counter = 0;
        while(counter<N) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planet temp = new Planet(xP,yP,xV,yV,m,img);
            planets[counter] = temp;
            counter++;
        }
        return planets;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double universe_radius = readRadius(filename);

        StdDraw.enableDoubleBuffering();

        for (int time = 0; time<T; time++) {
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            for (int i=0;i<planets.length;i++) {                
                double fX = planets[i].calcNetForceExertedByX(planets);
                double fY = planets[i].calcNetForceExertedByY(planets);
                xForces[i] = fX;
                yForces[i] = fY;
                planets[i].update(dt, fX, fY);
            }
            // Drawing the Background
            StdDraw.setScale(-universe_radius, universe_radius);
            StdDraw.clear();
            StdDraw.picture(0,0,bgImg);
            StdDraw.show();

            // Drawing all of the planets
            for (Planet p : planets){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time+=dt;
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", universe_radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                          planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }
}







