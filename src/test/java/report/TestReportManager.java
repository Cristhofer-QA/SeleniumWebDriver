package report;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestReportManager {
    private static final String FILE_PATH = "target/reports/report-slack/test-report.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void saveReport() throws IOException {
        TestExecutionReport report = new TestExecutionReport();
        new File("target/reports/report-slack").mkdirs();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), report);
    }
    
}
