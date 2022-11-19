// Programmer: Kevin Kim
// Instructor: Professor Raheja
// Class: CS 3010-03
// Date: 11/19/2022
// Project: Locating Roots with Bisection, Newton-Raphson, Secant, and False-Position methods

import java.lang.Math;

public class Main
{
    public static void main(String[] args)
    {
        int maxIterations = 100;
        double error = 0.01;

        // test the 4 methods for the first equation.
        System.out.println("Performing the Bisection method for Part (a):");
        Bisection1(0, 1, maxIterations, error);
        Bisection1(1, 2, maxIterations, error);
        Bisection1(3, 4, maxIterations, error);

        System.out.println("Performing the Newton-Raphson method for Part (a):");
        NewtonRaphson1(-5, maxIterations, error);
        NewtonRaphson1(2, maxIterations, error);
        NewtonRaphson1(3, maxIterations, error);

        System.out.println("Performing the Secant method for Part (a):");
        Secant1(0, 1, maxIterations, error);
        Secant1(1, 2, maxIterations, error);
        Secant1(3, 4, maxIterations, error);

        System.out.println("Performing the False-Position method for Part (a):");
        FalsePosition1(0, 1, maxIterations);
        FalsePosition1(1, 2, maxIterations);
        FalsePosition1(3, 4, maxIterations);

        // test the 4 methods for the second equation.
        System.out.println("Performing the Bisection method for Part (b):");
        Bisection2(120, 130, maxIterations, error);

        System.out.println("Performing the Newton-Raphson method for Part (b):");
        NewtonRaphson2(10, maxIterations, error);

        System.out.println("Performing the Secant method for Part (b):");
        Secant2(120, 130, maxIterations, error);

        System.out.println("Performing the False-Position method for Part (b):");
        FalsePosition2(120, 130, maxIterations);

        System.out.println("\nTerminating the program... Good bye!");
    }

    // this function is the first function that was given in the project prompt.
    public static double Function1(double x)
    {
        // (a) f(x) = 2x^3 – 11.7x^2 + 17.7x – 5
        return (2 * Math.pow(x, 3)) - (11.7 * Math.pow(x, 2)) + (17.7 * x) - 5;
    }

    public static double DerivedFunction1(double x)
    {
        // (a) f(x) = 2x^3 – 11.7x^2 + 17.7x – 5
        //     f'(x) = 6x^2 – 23.4x + 17.7
        return 6 * Math.pow(x, 2) - 23.4 * x + 17.7;
    }

    // this function is the second function that was given in the project prompt.
    public static double Function2(double x)
    {
        // (b) f(x) = x + 10 – x * cosh(50/x)
        return x + 10 - x * Math.cosh(50/x) ;
    }

    public static double DerivedFunction2(double x)
    {
        // (b) f(x) = x + 10 – x * cosh(50/x)
        //     f'(x) = 1 + (50 * Math.sinh(50/x) / x) - Math.cosh(50/x)
        return 1 + (50 * Math.sinh(50/x) / x) - Math.cosh(50/x);
    }

    // This method performs the bisection method on the first function from the project prompt.
    public static void Bisection1(double a, double b, int maxIterations, double epsilon)
    {
        // check to see if the product of the two returned values is positive
        if (Function1(a) * Function1(b) > 0)
        {
            // if so, notify the user that he/she had inputted wrong intervals
            // since the signs of these two values are the same.
            System.out.println("You have inputted wrong intervals... "
                    + "The function has the same signs at a and b\n");
            return;
        }

        // otherwise, perform the bisection method for Part (a) of this project.
        double error = b - a;
        double c = a;

        // iterate until 100 iterations or until the root had been found.
        for (int i = 0; i < maxIterations; i++)
        {
            error /= 2;
            c = a + error;

            System.out.println("At iteration #" + (i + 1) + ": c = " + c
                             + ", f(c) = " + Function1(c) + ", error = " + error);

            // check to see if the solution is convergent.
            if (Math.abs(error) < epsilon)
            {
                // if so, simply return to the caller.
                System.out.println("Converged.");
                break;
            }
            // if not, check to see if the root has been found.
            else if (Function1(c) == 0.0)
            {
                // if the c value is at 0, then the root has been found.
                break;
            }
            // otherwise, keep updating the bounds.
            else if (Function1(c) * Function1(a) < 0)
            {
                b = c;
            }
            else
            {
                a = c;
            }
        }

        // display the root.
        System.out.println("The value of the root: " + c + "\n");
    }

    // This method performs the bisection method with the second function from the project prompt.
    public static void Bisection2(double a, double b, int maxIterations, double epsilon)
    {
        // check to see if the product of the two returned values is positive
        if (Function2(a) * Function2(b) > 0)
        {
            // if so, notify the user that he/she had inputted wrong intervals
            // since the signs of these two values are the same.
            System.out.println("You have inputted wrong intervals... "
                    + "The function has the same signs at a and b\n");
            return;
        }

        // otherwise, perform the bisection method for Part (a) of this project.
        double error = b - a;
        double c = a;

        // iterate until 100 iterations or until the root had been found.
        for (int i = 0; i < maxIterations; i++)
        {
            error /= 2;
            c = a + error;

            System.out.println("At iteration #" + (i + 1) + ": c = " + c
                    + ", f(c) = " + Function2(c) + ", error = " + error);

            // check to see if the solution is convergent.
            if (Math.abs(error) < epsilon)
            {
                // if so, simply return to the caller.
                System.out.println("Converged.");
                break;
            }
            // if not, check to see if the root has been found.
            else if (Function2(c) == 0.0)
            {
                // if the c value is at 0, then the root has been found.
                break;
            }
            // otherwise, keep updating the bounds.
            else if (Function2(c) * Function2(a) < 0)
            {
                b = c;
            }
            else
            {
                a = c;
            }
        }

        // display the root.
        System.out.println("The value of the root: " + c + "\n");
    }

    public static void NewtonRaphson1(double val, int maxIterations, double epsilon)
    {
        double error;
        double fx;

        for (int i = 0; i < maxIterations; i++)
        {
            error = Function1(val) / DerivedFunction1(val);
            // x(i+1) = x(i) - (f(x)/f'(x))
            val = val - error;
            fx = Function1(val);

            System.out.println("At iteration #" + (i + 1) + ": x = " + val
                                                + ", f(x) = " + fx + ", error = " + error);

            // check to see if the solution is convergent.
            if (Math.abs(error) < epsilon)
            {
                // if so, simply return to the caller.
                System.out.println("Converged.");
                System.out.println("The value of the root: " + val + "\n");
                return;
            }

        }
        // if we have not found the root within max iterations, notify the user.
        System.out.println("Failed to find the root within the given interval...");    }

    public static void NewtonRaphson2(double val, int maxIterations, double epsilon)
    {
        double error;
        double fx;

        for (int i = 0; i < maxIterations; i++)
        {
            error = Function2(val) / DerivedFunction2(val);
            // x(i+1) = x(i) - (f(x)/f'(x))
            val = val - error;
            fx = Function2(val);

            System.out.println("At iteration #" + (i + 1) + ": x = " + val
                                                + ", f(x) = " + fx + ", error = " + error);

            // check to see if the solution is convergent.
            if (Math.abs(error) < epsilon)
            {
                // if so, simply return to the caller.
                System.out.println("Converged.");
                System.out.println("The value of the root: " + val + "\n");
                return;
            }

        }
        // if we have not found the root within max iterations, notify the user.
        System.out.println("Failed to find the root within the given interval...");    }

    public static void Secant1(double a, double b, int maxIterations, double epsilon)
    {
        double d;
        double fa = Function1(a);
        double fb = Function1(b);

        // check to see if it is necessary to interchange the endpoints a and b.
        if (Math.abs(Function1(a)) > Math.abs(Function1(b)))
        {
            // if so, interchange the values for a and b.
            double temp = a;
            a = b;
            b = temp;

            // also, interchange the values for fa and fb.
            temp = fa;
            fa = fb;
            fb = temp;

        } // end if

        for (int i = 2; i < maxIterations; i++)
        {
            // check to see if it is necessary to interchange the endpoints a and b again.
            if (Math.abs(Function1(a)) > Math.abs(Function1(b)))
            {
                // if so, interchange the values for a and b.
                double temp = a;
                a = b;
                b = temp;

                // also, interchange the values for fa and fb.
                temp = fa;
                fa = fb;
                fb = temp;

            } // end if

            // perform the secant method.
            d = (b - a) / (fb - fa);
            b = a;
            fb = fa;
            d *= fa;

            // check to see if the solution is convergent.
            if (Math.abs(d) < epsilon)
            {
                // if so, simply return to the caller.
                System.out.println("Converged.");
                System.out.println("The value of the root: " + (a - d) + "\n");
                return;
            }

            // otherwise, keep iterating.
            a -= d;
            fa = Function1(a);

            System.out.println("At iteration #" + (i - 1) + ": a = " + a + ", f(a) = " + fa);
        }

        // if we have not found the root within max iterations, notify the user.
        System.out.println("Failed to find the root within the given interval...");

    }

    public static void Secant2(double a, double b, int maxIterations, double epsilon)
    {
        double d;
        double fa = Function2(a);
        double fb = Function2(b);

        // check to see if it is necessary to interchange the endpoints a and b.
        if (Math.abs(Function2(a)) > Math.abs(Function2(b)))
        {
            // if so, interchange the values for a and b.
            double temp = a;
            a = b;
            b = temp;

            // also, interchange the values for fa and fb.
            temp = fa;
            fa = fb;
            fb = temp;

        } // end if

        for (int i = 2; i < maxIterations; i++)
        {
            // check to see if it is necessary to interchange the endpoints a and b again.
            if (Math.abs(Function2(a)) > Math.abs(Function2(b)))
            {
                // if so, interchange the values for a and b.
                double temp = a;
                a = b;
                b = temp;

                // also, interchange the values for fa and fb.
                temp = fa;
                fa = fb;
                fb = temp;

            } // end if

            // perform the secant method.
            d = (b - a) / (fb - fa);
            b = a;
            fb = fa;
            d *= fa;

            // check to see if the solution is convergent.
            if (Math.abs(d) < epsilon)
            {
                // if so, simply return to the caller.
                System.out.println("Converged.");
                System.out.println("The value of the root: " + (a - d) + "\n");
                return;
            }

            // otherwise, keep iterating.
            a -= d;
            fa = Function2(a);

            System.out.println("At iteration #" + (i - 1) + ": a = " + a + ", f(a) = " + fa);
        }

        // if we have not found the root within max iterations, notify the user.
        System.out.println("Failed to find the root within the given interval...");

    }

    public static void FalsePosition1(double a, double b, int maxIterations)
    {
        if (Function1(a) * Function1(b) > 0)
        {
            System.out.println("You have inputted wrong intervals... "
                    + "The function has the same signs at a and b\n");
            return;
        }

        double c = 0;

        for (int i = 0; i < maxIterations; i++)
        {
            // find the root.
            c = (a * Function1(b) - b * Function1(a)) / (Function1(b) - Function1(a));
            double fc = Function1(c);

            System.out.println("At iteration #" + (i + 1) + ": c = " + c + ", f(c) = " + fc);

            // check to see if c is the root.
            if (fc == 0)
            {
                // if the c value is at 0, then the root has been found.
                break;
            }
            // otherwise, keep updating the bounds.
            else if (fc * Function1(a) < 0)
            {
                b = c;
            }
            else
            {
                a = c;
            }
        }

        // display the root.
        System.out.println("The value of the root: " + c + "\n");
    }

    public static void FalsePosition2(double a, double b, int maxIterations)
    {
        if (Function2(a) * Function2(b) > 0)
        {
            System.out.println("You have inputted wrong intervals... "
                    + "The function has the same signs at a and b\n");
            return;
        }

        double c = 0;

        for (int i = 0; i < maxIterations; i++)
        {
            // find the root.
            c = (a * Function2(b) - b * Function2(a)) / (Function2(b) - Function2(a));
            double fc = Function2(c);
            System.out.println("At iteration #" + (i + 1) + ": c = " + c + ", f(c) = " + fc);

            // check to see if c is the root.
            if (fc == 0)
            {
                // if the c value is at 0, then the root has been found.
                break;
            }
            // otherwise, keep updating the bounds.
            else if (fc * Function2(a) < 0)
            {
                b = c;
            }
            else
            {
                a = c;
            }
        }

        // display the root.
        System.out.println("The value of the root: " + c + "\n");
    }
}

