package githubRepo.tests;

import githubRepo.pages.issueRepoPage.IssueRepoPage;

public class TestBase {
    IssueRepoPage steps = new IssueRepoPage();
    public static String URL = "https://github.com";
    TestData data = new TestData();
}
