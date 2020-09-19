public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private final static double GRAVITATIONAL_CONSTANT = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public double calcForceExertedBy(Planet p) {
        double r = this.calcDistance(p);
        return (GRAVITATIONAL_CONSTANT * this.mass * p.mass) / (r * r);
    }

    public double calcForceExertedByX(Planet p) {
        double force = this.calcForceExertedBy(p);
        double dx = p.xxPos - this.xxPos;
        double r = this.calcDistance(p);
        return force * dx / r;
    }

    public double calcForceExertedByY(Planet p) {
        double force = this.calcForceExertedBy(p);
        double dy = p.yyPos - this.yyPos;
        double r = this.calcDistance(p);
        return force * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double net_force_x = 0;
        for (Planet p : allPlanets) {
            if (this.equals(p))
                continue;
            net_force_x += this.calcForceExertedByX(p);
        }
        // for (int i = 0; i<allPlanets.length; i++) {
        //     if (this.equals(allPlanets[i]))
        //         continue;
        //     net_force_x += this.calcForceExertedByX(allPlanets[i]);
        // }
        return net_force_x;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double net_force_y = 0;
        for (int i = 0; i<allPlanets.length; i++) {
            if (this.equals(allPlanets[i]))
                continue;
            net_force_y += this.calcForceExertedByY(allPlanets[i]);
        }
        return net_force_y;
    }

    public void update(double dt, double fX, double fY) {
        double a_x = fX / this.mass;
        double a_y = fY / this.mass;

        this.xxVel += dt * a_x;
        this.yyVel += dt * a_y;

        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + imgFileName);
        StdDraw.show();
    }
}