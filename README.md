# Argupedia
This project was developed using IDEA
├─main
│  ├─java
│  │  └─com
│  │      └─wqs
│  │          └─argu_backend
│  │              │  ArguBackEndApplication.java
│  │              │
│  │              ├─bean      This folder is used to store the various argumentation entity classes used in the system
│  │              │      ActionScheme.java         Java class corresponding to action scheme
│  │              │      AnalogyScheme.java        Java class corresponding to analogy scheme
│  │              │      Argument.java             Java entity class corresponding to MongoDB database.
│  │              │      AttackInfo.java           Used to receive information about the argument which be challenged in the back-end.
│  │              │      ChallengeInfo.java        Used to receive information about newly created challenge argument in the back-end.
│  │              │      CorrelationScheme.java    Java class corresponding to correlation to cause scheme
│  │              │      ExpertScheme.java         Java class corresponding to expert opinion scheme
│  │              │      PopularScheme.java        Java class corresponding to poulular scheme
│  │              │      PositionScheme.java       Java class corresponding to position to know scheme
│  │              │      Schema.java               Used to receive user-created argument data and facilitate back-end conversion of the 
                                                   data into the corresponding class of the argument scheme.
│  │              │
│  │              ├─config
│  │              │      MongodbConfig.java        A cutonfiguration file for connecting to MongoDB
│  │              │
│  │              ├─controller
│  │              │      Challenge.java            For handling operations related to the Create Challenge Argument page(challenge.html).
│  │              │      Create.java               For handling operations related to the Create New Framework page(createFrame.html).
│  │              │      Transfer.java             For jump links in the navigation bar.
│  │              │      View.java                 For handling operations related to the Argument Display page and the Search page(select.html).
│  │              │     
│  │              ├─dao
│  │              │      ArgumentDao.java          Calling functions to operate on the database
│  │              │
│  │              ├─grounded
│  │              │      G_Labelling.java          A labelling algorithm for grounded semantics.
│  │              │
│  │              └─service
│  │                      ArgumentService.java    An interface that defines some functions for database processing
│  │                      ArgumentServiceImpl.java   Implementation of the interface above.
│  │
│  └─resources
│      │  application.properties
│      │
│      ├─static
│      │  ├─css
│      │  │      challenge.css                    CSS styles for the Create Challenge Argument page(challenge.html).
│      │  │      home.css                         CSS styles for the Home page(home.html).
│      │  │      new_arg.css                      CSS styles for the Create New Framework page(createFrame.html).
│      │  │      popper.min.js                    Third-party library required for Bootstrap3 to run.
│      │  │      search.css                       CSS styles for the Search page(search.html).
│      │  │      select.css                       CSS styles for the Argument Display page(select.html).
│      │  │      view.css                         CSS styles for the Framework List page(view.html).
│      │  │
│      │  ├─img        Images used in search.html
│      │  │      cloud.png
│      │  │      mountain.png
│      │  │      oran_small_1.png
│      │  │      oran_small_small.png
│      │  │      sun.png
│      │  │
│      │  └─js
│      │          challenge.js                    JS for the Create Challenge Argument page(challenge.html).
│      │          createFrame.js                  JS for the Create New Framework page(createFrame.html).
│      │          dagre-d3.min.js                 Third-party library for the select.html, drawing each argument in the argument framework and the arrows between them.
                                                        https://dagrejs.github.io/project/dagre-d3/latest/dagre-d3.min.js
│      │          dagre.js                        Third-party library for the select.html, drawing each argument in the argument framework and the arrows between them.
                                                        https://dagrejs.github.io/project/dagre/latest/dagre.js
│      │          dagre.min.js                    Third-party library for the select.html, drawing each argument in the argument framework and the arrows between them.
                                                        https://dagrejs.github.io/project/dagre/late- st/dagre.min.js
│      │          jquery-3.6.0.js                 Third-party library, https://code.jquery.com/jquery-3.6.0.js
│      │          search.js                       JS for the Search page(search.html). The content of this file is empty.
│      │          select.js                       JS for the Argument Display page(select.html).
│      │          view.js                         JS for the Framework List page(view.html).
│      │
│      └─templates
│              challenge.html                     HTML for the Create Challenge Argument page. For creating challenge arguments.
│              createFrame.html                   HTML for the Create New Framework page. For creating initial argument in a new argument framework.
│              home.html                          HTML for the Home page.
│              search.html                        HTML for the Search page. Used to search for the ID of an argument framework.
│              select.html                        HTML for the Argument Display page. Display arguments under an argument framework in the form of a directed graph. 
                                                   This page also contains a voting functionality. After selecting an argument and then the corresponding critical question on 
                                                    this page, the page will jump to challenge.html. 
│              view.html                          HTML for the Framework List page. This page shows all the argument frameworks in the system. This page also allows users to 
                                                   search for arguments based on keywords in the title.
│
└─test
    └─java
        └─com
            └─wqs
                └─argu_backend
                        ArguBackEndApplicationTests.java
