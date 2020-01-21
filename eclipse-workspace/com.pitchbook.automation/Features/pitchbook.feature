Feature: Pitchbook flow text edit image edit and video edit

  Scenario Outline: Pitchbook signin with valid credentials
    Given Open chrome with Pitchbook URL
    When User enters valid <username> and <password>  
    And User clicks on the Signin button
    Then User should be able to signin successfully
   
     Given user click on edit mode toggle switch from top menu
     Then system should display pitchbook editor enable edit mode popup
     And  Click on Why BlockBuster tab and Mouse over on any one of the Cards
     And  Click on Edit icon and Enter any desired text in place of already existing text
     Then System displayed the changed text
     
     
        Examples: 
      | username                             | password    |
      | aaron.english@advantagesolutions.net | AsmPass111! |
  
     
     