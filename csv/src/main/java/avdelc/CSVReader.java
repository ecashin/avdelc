/* read CSV from standard input */

package avdelc;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStreamReader;

public class CSVReader {
    public static void main(String[] args) throws IOException {
        int recordNumber = 0;

        for (CSVRecord rec : CSVFormat.DEFAULT.parse(new InputStreamReader(System.in))) {
            recordNumber++;
            int fieldNumber = 0;
            for (String field : rec) {
                fieldNumber++;
                System.out.format("%d: %d: %s%n", recordNumber, fieldNumber, field);
            }
        }
    }
}
