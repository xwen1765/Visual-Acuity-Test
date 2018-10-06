import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;

public class TargetNumberRandomGenerator {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream out = new PrintStream(new FileOutputStream("TargetFile.txt"));
		Random ran = new Random();

		int trial = 1;

		int valid = 0, invalid = 0, neutral = 0;
		do {
			out.println(trial);
			out.println(ran.nextInt(2));// leftRotate
			out.println(ran.nextInt(2));// rightRotate

			out.println(ran.nextInt(31) + 5);// Percentage of gap size

			if (ran.nextInt(1000) < 667) {
				if (ran.nextInt(1000) < 700) {
					out.println(1);
					valid++;
				} else {
					out.println(0);
					invalid++;
				}
			} else {
				out.println(2);
				neutral++;
			}

			out.println("*");
			trial++;
		} while (trial < 3600);
		out.close();
		System.out.println(valid + "valid, " + invalid + "invalid, " + neutral + "neutral");
	}

}
