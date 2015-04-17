@Test
  Feature: YandexSearch

  @Test_001
  Scenario: TestSearch
    Given I am on Yandex start page
    When I search "test search"
    Then I open first link
