/* read CSV from standard input */

package avdelc;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class CSVReader {
    public static void main(String[] args) throws IOException {
        int recordNumber = 0;

        Reader reader = null;
        if (args.length > 0) {
            reader = new FileReader(args[0]);
        } else {
            reader = new InputStreamReader(System.in);
        }

        for (CSVRecord rec : CSVFormat.DEFAULT.parse(reader)) {
            recordNumber++;
            int fieldNumber = 0;
            for (String field : rec) {
                fieldNumber++;
                System.out.format("%d: %d: %s%n", recordNumber, fieldNumber, field);
            }
        }
    }
}
