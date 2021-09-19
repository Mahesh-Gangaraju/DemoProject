package Reporting;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Managers.ConfigFileReader;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class CucumberReport {
    public void generateReport() {
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            public void run()
            {
                String projectFolder=System.getProperty("user.dir");
                String TargetFolder=projectFolder+"/target";
                File reportOutputDirectory = new File(TargetFolder);
                List<String> jsonFiles = new ArrayList<String>();
                jsonFiles.add(TargetFolder+"/cucumber.json");
                String buildNumber = "1";
                String projectName = "Demo";
                boolean runWithJenkins = false;
                boolean parallelTesting = false;
                Configuration configuration = new Configuration(reportOutputDirectory,projectName);
                configuration.setBuildNumber(buildNumber);
                ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
                reportBuilder.generateReports();
            }
        });
    }
}
