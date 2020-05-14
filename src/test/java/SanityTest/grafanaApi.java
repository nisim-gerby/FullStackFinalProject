package SanityTest;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlow.apiFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class grafanaApi extends commonOps
{
//    @Test(description = "test01: get team from Grafana ")
//    @Description("Test description: login to Grafana and get team")
//    public void test01_GetTeam()
//    {
//        verifications.verifyText(apiFlows.getTeamProperty("teams[1].name"),"nisimTeam");
//    }

    @Test(description = "test01: add team and verify it ")
    @Description("Test description: add team  to Grafana and verify it")
    public void test01_addTeamAndVerify()
    {
        apiFlows.postTeam("nisim2","nisim@team2.com");
        verifications.verifyText(apiFlows.getTeamProperty("teams[0].name"),"nisim2");
    }
    @Test(description = "test02: update team and verify it ")
    @Description("Test description: update team  to Grafana and verify it")
    public void test02_updateTeamAndVerify()
    {
        apiFlows.updateTeam("nisim0","nisim@team0.com","6");
        verifications.verifyText(apiFlows.getTeamProperty("teams[0].name"),"nisim0");
    }
    @Test(description = "test03: delete team from Grafana")
    @Description("Test description: delete team from Grafana and verify it")
    public void test03_deleteTeamAndVerify()
    {
        apiFlows.deleteTeam("6");
        verifications.verifyText(apiFlows.getTeamProperty("totalCount"),"0");
    }




}
