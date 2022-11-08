# MP1 Feedback

## Grade: A

**Compiles**: Yes

**Timeout**: No

## Test Results
### cpen221.mp1.ngrams.Task1
| Test Status | Count |
| ----------- | ----- |
|tests|7|
|skipped|0|
|failures|1|
|errors|0|
#### Failed Tests
1. `testMiscIssues() (org.opentest4j.AssertionFailedError: expected: <[{is=5, this=5, test=6, a=5, 5=2}, {test test=1, a test=5, 5 this=1, is a=5, 5 5=1, this is=5}, {is a test=5, this is a=5, a test test=1, 5 5 this=1, 5 this is=1}, {5 5 this is=1, this is a test=5, is a test test=1, 5 this is a=1}, {5 5 this is a=1, this is a test test=1, 5 this is a test=1}, {5 5 this is a test=1}]> but was: <[{this=5, is=5, a=5, test=2, 5=2}, {this is=5, is a=5, a test=1, test test=1, 5 5=1, 5 this=1}, {this is a=5, is a test=1, a test test=1, 5 5 this=1, 5 this is=1}, {this is a test=1, is a test test=1, 5 5 this is=1, 5 this is a=1}, {this is a test test=1, 5 5 this is a=1, 5 this is a test=1}, {5 5 this is a test=1}]>)`

### cpen221.mp1.ratemyprofessor.Task2
| Test Status | Count |
| ----------- | ----- |
|tests|7|
|skipped|0|
|failures|0|
|errors|0|

### cpen221.mp1.autocompletion.Task3
| Test Status | Count |
| ----------- | ----- |
|tests|8|
|skipped|0|
|failures|0|
|errors|0|

### cpen221.mp1.sentimentanalysis.Task4
| Test Status | Count |
| ----------- | ----- |
|tests|12|
|skipped|0|
|failures|1|
|errors|0|
#### Failed Tests
1. `testSomeMissingWords() (org.opentest4j.AssertionFailedError: expected: <3.0> but was: <5.0>)`

## Code Coverage
### SentimentAnalyzer
| Metric | Coverage |
| ------ | -------- |
|LINE_MISSED|0|
|LINE_COVERED|96|
|BRANCH_MISSED|1|
|BRANCH_COVERED|51|
### DataAnalyzer
| Metric | Coverage |
| ------ | -------- |
|LINE_MISSED|0|
|LINE_COVERED|43|
|BRANCH_MISSED|0|
|BRANCH_COVERED|22|
### NGrams
| Metric | Coverage |
| ------ | -------- |
|LINE_MISSED|0|
|LINE_COVERED|68|
|BRANCH_MISSED|2|
|BRANCH_COVERED|38|
### AutoCompletor
| Metric | Coverage |
| ------ | -------- |
|LINE_MISSED|0|
|LINE_COVERED|60|
|BRANCH_MISSED|1|
|BRANCH_COVERED|39|

## Comments
In DataAnalyzer, the categories of low and high should be constants rather than magic numbers. In general, specs and variable names are clear and descriptive. Make sure to follow camelCase naming convention for variables. Readability could be improved through the use of helpful comments. While the "what" may be obvious from the line of code itself, the "why" is often much harder to convey and is where we get the most out of adittional comments. getWords() should be added to a Util class rather than having the code copy pasted in many locations.


**Detailed Code Analysis**

| Filename | Line | Issue | Explanation |
| -------- | ---- | ----- | ----------- |
|AutoCompletor.java|7|	ModifiedCyclomaticComplexity|	The class 'AutoCompletor' has a Modified Cyclomatic Complexity of 4 (Highest = 15).|
|AutoCompletor.java|7|	StdCyclomaticComplexity|	The class 'AutoCompletor' has a Standard Cyclomatic Complexity of 4 (Highest = 15).|
|AutoCompletor.java|10|	BeanMembersShouldSerialize|	Found non-transient, non-static member. Please mark as transient or provide accessors.|
|AutoCompletor.java|18|	UseVarargs|	Consider using varargs for methods or constructors which take an array the last parameter.|
|AutoCompletor.java|19|	ArrayIsStoredDirectly|	The user-supplied array 'searchTerms' is stored directly.|
|AutoCompletor.java|51|	ModifiedCyclomaticComplexity|	The method 'allMatches' has a Modified Cyclomatic Complexity of 15.|
|AutoCompletor.java|51|	StdCyclomaticComplexity|	The method 'allMatches' has a Standard Cyclomatic Complexity of 15.|
|AutoCompletor.java|51|	CognitiveComplexity|	The method 'allMatches(String)' has a cognitive complexity of 41, current threshold is 15|
|AutoCompletor.java|51|	CyclomaticComplexity|	The method 'allMatches(String)' has a cyclomatic complexity of 17.|
|AutoCompletor.java|51|	NPathComplexity|	The method 'allMatches(String)' has an NPath complexity of 870, current threshold is 200|
|AutoCompletor.java|54|	LawOfDemeter|	Potential violation of Law of Demeter (method chain calls)|
|AutoCompletor.java|55|	LawOfDemeter|	Potential violation of Law of Demeter (method chain calls)|
|AutoCompletor.java|59|	DataflowAnomalyAnalysis|	Found 'DD'-anomaly for variable 'arr' (lines '59'-'61').|
|AutoCompletor.java|61|	DataflowAnomalyAnalysis|	Found 'DD'-anomaly for variable 'arr' (lines '61'-'61').|
|AutoCompletor.java|63|	AvoidLiteralsInIfCondition|	Avoid using Literals in Conditional Statements|
|AutoCompletor.java|66|	DataflowAnomalyAnalysis|	Found 'DD'-anomaly for variable 'numArr' (lines '66'-'68').|
|AutoCompletor.java|68|	DataflowAnomalyAnalysis|	Found 'DD'-anomaly for variable 'numArr' (lines '68'-'68').|
|AutoCompletor.java|78|	UseCollectionIsEmpty|	Substitute calls to size() == 0 (or size() != 0, size() > 0, size() < 1) with calls to isEmpty()|
|AutoCompletor.java|83|	AvoidDeeplyNestedIfStmts|	Deeply nested if..then statements are hard to read|
|AutoCompletor.java|88|	AvoidDeeplyNestedIfStmts|	Deeply nested if..then statements are hard to read|
|AutoCompletor.java|136|	LawOfDemeter|	Potential violation of Law of Demeter (method chain calls)|
## Checkstyle Results
### `AutoCompletor.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 39 | 9 | `'for' is not followed by whitespace.` |
| 39 | 18 | `'=' is not followed by whitespace.` |
| 39 | 18 | `'=' is not preceded with whitespace.` |
| 39 | 23 | `'<' is not preceded with whitespace.` |
| 39 | 41 | `'{' is not preceded with whitespace.` |
| 53 | 9 | `'for' is not followed by whitespace.` |
| 53 | 39 | `'{' is not preceded with whitespace.` |
| 55 | 13 | `'if' is not followed by whitespace.` |
| 55 | 46 | `',' is not followed by whitespace.` |
| 55 | 55 | `'+' is not followed by whitespace.` |
| 55 | 55 | `'+' is not preceded with whitespace.` |
| 55 | 59 | `'{' is not preceded with whitespace.` |
| 60 | 9 | `'for' is not followed by whitespace.` |
| 60 | 18 | `'=' is not followed by whitespace.` |
| 60 | 18 | `'=' is not preceded with whitespace.` |
| 60 | 23 | `'<' is not preceded with whitespace.` |
| 60 | 45 | `'{' is not preceded with whitespace.` |
| 63 | 9 | `'if' is not followed by whitespace.` |
| 63 | 26 | `'>' is not followed by whitespace.` |
| 63 | 26 | `'>' is not preceded with whitespace.` |
| 78 | 13 | `'if' is not followed by whitespace.` |
| 78 | 32 | `'>' is not followed by whitespace.` |
| 78 | 32 | `'>' is not preceded with whitespace.` |
| 78 | 35 | `'{' is not preceded with whitespace.` |
| 79 | 17 | `'for' is not followed by whitespace.` |
| 79 | 39 | `'{' is not preceded with whitespace.` |
| 82 | 21 | `'for' is not followed by whitespace.` |
| 82 | 30 | `'=' is not followed by whitespace.` |
| 82 | 30 | `'=' is not preceded with whitespace.` |
| 82 | 35 | `'<' is not followed by whitespace.` |
| 82 | 35 | `'<' is not preceded with whitespace.` |
| 82 | 55 | `'{' is not preceded with whitespace.` |
| 83 | 25 | `'if' is not followed by whitespace.` |
| 83 | 37 | `'==' is not followed by whitespace.` |
| 83 | 37 | `'==' is not preceded with whitespace.` |
| 83 | 54 | `'==' is not followed by whitespace.` |
| 83 | 54 | `'==' is not preceded with whitespace.` |
| 83 | 59 | `'{' is not preceded with whitespace.` |
| 87 | 21 | `'for' is not followed by whitespace.` |
| 87 | 30 | `'=' is not followed by whitespace.` |
| 87 | 30 | `'=' is not preceded with whitespace.` |
| 87 | 44 | `'-' is not followed by whitespace.` |
| 87 | 44 | `'-' is not preceded with whitespace.` |
| 87 | 49 | `'>=' is not followed by whitespace.` |
| 87 | 49 | `'>=' is not preceded with whitespace.` |
| 87 | 58 | `'{' is not preceded with whitespace.` |
| 88 | 25 | `'if' is not followed by whitespace.` |
| 88 | 37 | `'==' is not followed by whitespace.` |
| 88 | 37 | `'==' is not preceded with whitespace.` |
| 88 | 52 | `'==' is not followed by whitespace.` |
| 88 | 52 | `'==' is not preceded with whitespace.` |
| 88 | 57 | `'{' is not preceded with whitespace.` |
| 93 | 89 | `'+' is not followed by whitespace.` |
| 93 | 89 | `'+' is not preceded with whitespace.` |
| 111 | 9 | `'if' is not followed by whitespace.` |
| 111 | 17 | `'>' is not preceded with whitespace.` |
| 111 | 33 | `'{' is not preceded with whitespace.` |
### `AutoCompletorGUI.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 | None | `File does not end with a newline.` |
| 43 | 8 | `Unused import - java.io.FileNotFoundException.` |
| 144 | 25 | `'.' should be on the previous line.` |
| 146 | 33 | `'.' should be on the previous line.` |
| 149 | 33 | `'.' should be on the previous line.` |
| 152 | 25 | `'.' should be on the previous line.` |
| 154 | 25 | `'.' should be on the previous line.` |
| 155 | 25 | `'.' should be on the previous line.` |
| 161 | 25 | `'.' should be on the previous line.` |
| 163 | 33 | `'.' should be on the previous line.` |
| 164 | 41 | `'.' should be on the previous line.` |
| 165 | 41 | `'.' should be on the previous line.` |
| 166 | 33 | `'.' should be on the previous line.` |
| 167 | 33 | `'.' should be on the previous line.` |
| 189 | 35 | `'5' is a magic number.` |
| 195 | 11 | `Found a TODO or FIXME comment` |
| 214 | 9 | `Method AutoCompletorPanel length is 281 lines (max allowed is 80).` |
| 250 | 28 | `'13' is a magic number.` |
| 251 | 30 | `'20' is a magic number.` |
| 276 | 25 | `'if' construct must use '{}'s.` |
| 317 | 21 | `'}' at column 21 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 352 | 78 | `'*' is not followed by whitespace.` |
| 352 | 78 | `'*' is not preceded with whitespace.` |
| 353 | 76 | `'*' is not followed by whitespace.` |
| 353 | 76 | `'*' is not preceded with whitespace.` |
| 356 | 49 | `'*' is not followed by whitespace.` |
| 356 | 49 | `'*' is not preceded with whitespace.` |
| 448 | 25 | `'{' at column 25 should be on the previous line.` |
| 452 | 25 | `'{' at column 25 should be on the previous line.` |
| 452 | 25 | `'{' at column 25 should have line break after.` |
| 454 | 25 | `'{' at column 25 should be on the previous line.` |
| 477 | 29 | `'.' should be on the previous line.` |
| 479 | 37 | `'.' should be on the previous line.` |
| 482 | 37 | `'.' should be on the previous line.` |
| 491 | 29 | `'.' should be on the previous line.` |
| 492 | 29 | `'.' should be on the previous line.` |
| 501 | 9 | `'{' at column 9 should be on the previous line.` |
| 509 | 34 | `'*' is not followed by whitespace.` |
| 509 | 34 | `'*' is not preceded with whitespace.` |
| 538 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 569 | 25 | `'if' construct must use '{}'s.` |
| 589 | 17 | `'}' at column 17 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 610 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 633 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 637 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 646 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
### `In.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 | None | `File does not end with a newline.` |
| 88 | 9 | `'if' construct must use '{}'s.` |
| 93 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 107 | 9 | `'if' construct must use '{}'s.` |
| 113 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 127 | 9 | `'if' construct must use '{}'s.` |
| 134 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 150 | 9 | `'if' construct must use '{}'s.` |
| 151 | 9 | `'if' construct must use '{}'s.` |
| 186 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 203 | 9 | `'if' construct must use '{}'s.` |
| 269 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 290 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 304 | 9 | `'if' construct must use '{}'s.` |
| 323 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 341 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 346 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 364 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 369 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 387 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 392 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 410 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 415 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 433 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 438 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 458 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 463 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 482 | 13 | `'if' construct must use '{}'s.` |
| 483 | 13 | `'if' construct must use '{}'s.` |
| 484 | 13 | `'if' construct must use '{}'s.` |
| 485 | 13 | `'if' construct must use '{}'s.` |
| 488 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 505 | 9 | `'if' construct must use '{}'s.` |
| 507 | 57 | `'-' is not followed by whitespace.` |
| 507 | 57 | `'-' is not preceded with whitespace.` |
| 508 | 9 | `'for' construct must use '{}'s.` |
| 508 | 42 | `'-' is not followed by whitespace.` |
| 508 | 42 | `'-' is not preceded with whitespace.` |
| 509 | 39 | `'+' is not followed by whitespace.` |
| 509 | 39 | `'+' is not preceded with whitespace.` |
| 537 | 9 | `'for' construct must use '{}'s.` |
| 551 | 9 | `'for' construct must use '{}'s.` |
| 565 | 9 | `'for' construct must use '{}'s.` |
### `DataAnalyzer.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 | None | `File does not end with a newline.` |
| 23 | 33 | `Constant 'citiesData' must be in ALL_CAPS.` |
| 31 | 22 | `Control variable 'line' is modified.` |
| 40 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
### `DataWrapper.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 | None | `File does not end with a newline.` |
| 6 | 8 | `Unused import - cpen221.mp1.autocompletion.gui.In.` |
| 10 | 20 | `Class member (field) 'dataReader' may not be public.` |
### `Histogram.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 20 | 17 | `'.' should be on the previous line.` |
| 21 | 17 | `'.' should be on the previous line.` |
| 22 | 17 | `'.' should be on the previous line.` |
| 23 | 17 | `'.' should be on the previous line.` |
| 41 | 45 | `'10' is a magic number.` |
| 41 | 49 | `'5' is a magic number.` |
| 41 | 52 | `'20' is a magic number.` |
| 41 | 56 | `'4' is a magic number.` |
| 45 | 31 | `'7' is a magic number.` |
| 45 | 34 | `'21' is a magic number.` |
| 45 | 38 | `'6' is a magic number.` |
| 45 | 41 | `'9' is a magic number.` |
### `NGrams.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 | None | `File does not end with a newline.` |
| 18 | 19 | `'=' is not followed by whitespace.` |
| 18 | 19 | `'=' is not preceded with whitespace.` |
| 19 | 19 | `'=' is not followed by whitespace.` |
| 19 | 19 | `'=' is not preceded with whitespace.` |
| 19 | 21 | `';' is not followed by whitespace.` |
| 19 | 23 | `'<' is not preceded with whitespace.` |
| 19 | 36 | `';' is not followed by whitespace.` |
| 19 | 41 | `'{' is not preceded with whitespace.` |
| 20 | 26 | `'=' is not followed by whitespace.` |
| 20 | 26 | `'=' is not preceded with whitespace.` |
| 36 | 24 | `'=' is not followed by whitespace.` |
| 36 | 24 | `'=' is not preceded with whitespace.` |
| 37 | 25 | `'=' is not followed by whitespace.` |
| 37 | 25 | `'=' is not preceded with whitespace.` |
| 38 | 9 | `'for' is not followed by whitespace.` |
| 38 | 18 | `'=' is not followed by whitespace.` |
| 38 | 18 | `'=' is not preceded with whitespace.` |
| 38 | 20 | `';' is not followed by whitespace.` |
| 38 | 22 | `'<' is not followed by whitespace.` |
| 38 | 22 | `'<' is not preceded with whitespace.` |
| 38 | 40 | `';' is not followed by whitespace.` |
| 38 | 45 | `'{' is not preceded with whitespace.` |
| 39 | 27 | `'=' is not followed by whitespace.` |
| 39 | 27 | `'=' is not preceded with whitespace.` |
| 40 | 13 | `'for' is not followed by whitespace.` |
| 40 | 22 | `'=' is not followed by whitespace.` |
| 40 | 22 | `'=' is not preceded with whitespace.` |
| 40 | 24 | `';' is not followed by whitespace.` |
| 40 | 26 | `'<=' is not followed by whitespace.` |
| 40 | 26 | `'<=' is not preceded with whitespace.` |
| 40 | 29 | `';' is not followed by whitespace.` |
| 40 | 34 | `'{' is not preceded with whitespace.` |
| 42 | 17 | `'for' is not followed by whitespace.` |
| 42 | 26 | `'=' is not followed by whitespace.` |
| 42 | 26 | `'=' is not preceded with whitespace.` |
| 42 | 28 | `';' is not followed by whitespace.` |
| 42 | 30 | `'<=' is not followed by whitespace.` |
| 42 | 30 | `'<=' is not preceded with whitespace.` |
| 42 | 44 | `'-' is not followed by whitespace.` |
| 42 | 44 | `'-' is not preceded with whitespace.` |
| 42 | 46 | `';' is not followed by whitespace.` |
| 42 | 51 | `'{' is not preceded with whitespace.` |
| 43 | 34 | `'=' is not followed by whitespace.` |
| 43 | 34 | `'=' is not preceded with whitespace.` |
| 44 | 21 | `'for' is not followed by whitespace.` |
| 44 | 30 | `'=' is not followed by whitespace.` |
| 44 | 30 | `'=' is not preceded with whitespace.` |
| 44 | 32 | `';' is not followed by whitespace.` |
| 44 | 34 | `'<' is not followed by whitespace.` |
| 44 | 34 | `'<' is not preceded with whitespace.` |
| 44 | 36 | `'+' is not followed by whitespace.` |
| 44 | 36 | `'+' is not preceded with whitespace.` |
| 44 | 38 | `';' is not followed by whitespace.` |
| 45 | 32 | `'=' is not followed by whitespace.` |
| 45 | 39 | `'+' is not followed by whitespace.` |
| 45 | 39 | `'+' is not preceded with whitespace.` |
| 45 | 43 | `'+' is not followed by whitespace.` |
| 45 | 43 | `'+' is not preceded with whitespace.` |
| 51 | 19 | `'=' is not followed by whitespace.` |
| 51 | 19 | `'=' is not preceded with whitespace.` |
| 63 | 19 | `'=' is not followed by whitespace.` |
| 63 | 19 | `'=' is not preceded with whitespace.` |
| 64 | 16 | `'=' is not followed by whitespace.` |
| 64 | 16 | `'=' is not preceded with whitespace.` |
| 65 | 9 | `'for' is not followed by whitespace.` |
| 65 | 18 | `'=' is not followed by whitespace.` |
| 65 | 18 | `'=' is not preceded with whitespace.` |
| 65 | 20 | `';' is not followed by whitespace.` |
| 65 | 22 | `'<' is not followed by whitespace.` |
| 65 | 22 | `'<' is not preceded with whitespace.` |
| 65 | 40 | `';' is not followed by whitespace.` |
| 65 | 45 | `'{' is not preceded with whitespace.` |
| 67 | 13 | `'if' is not followed by whitespace.` |
| 67 | 28 | `'>=' is not followed by whitespace.` |
| 67 | 28 | `'>=' is not preceded with whitespace.` |
| 67 | 34 | `'{' is not preceded with whitespace.` |
| 68 | 20 | `'=' is not preceded with whitespace.` |
| 76 | 13 | `'for' is not followed by whitespace.` |
| 76 | 22 | `'=' is not followed by whitespace.` |
| 76 | 22 | `'=' is not preceded with whitespace.` |
| 76 | 24 | `';' is not followed by whitespace.` |
| 76 | 26 | `'<' is not followed by whitespace.` |
| 76 | 26 | `'<' is not preceded with whitespace.` |
| 76 | 44 | `';' is not followed by whitespace.` |
| 79 | 35 | `'=' is not followed by whitespace.` |
| 81 | 25 | `'if' is not followed by whitespace.` |
| 81 | 29 | `'!=' is not followed by whitespace.` |
| 81 | 29 | `'!=' is not preceded with whitespace.` |
| 81 | 32 | `'+' is not followed by whitespace.` |
| 81 | 32 | `'+' is not preceded with whitespace.` |
| 81 | 34 | `'-' is not followed by whitespace.` |
| 81 | 34 | `'-' is not preceded with whitespace.` |
| 81 | 37 | `'{' is not preceded with whitespace.` |
| 82 | 29 | `'if' is not followed by whitespace.` |
| 82 | 33 | `'<' is not followed by whitespace.` |
| 82 | 33 | `'<' is not preceded with whitespace.` |
| 83 | 48 | `'+' is not followed by whitespace.` |
| 83 | 48 | `'+' is not preceded with whitespace.` |
| 83 | 57 | `'+' is not followed by whitespace.` |
| 83 | 57 | `'+' is not preceded with whitespace.` |
| 85 | 25 | `'}' is not followed by whitespace.` |
| 85 | 26 | `'else' is not followed by whitespace.` |
| 85 | 26 | `'else' is not preceded with whitespace.` |
| 85 | 30 | `'{' is not preceded with whitespace.` |
| 86 | 35 | `'+=' is not followed by whitespace.` |
| 86 | 35 | `'+=' is not preceded with whitespace.` |
| 89 | 38 | `';' is not followed by whitespace.` |
| 95 | 32 | `'=' is not preceded with whitespace.` |
| 96 | 32 | `'=' is not followed by whitespace.` |
| 96 | 32 | `'=' is not preceded with whitespace.` |
| 103 | 37 | `',' is not followed by whitespace.` |
| 128 | 34 | `'=' is not followed by whitespace.` |
| 128 | 34 | `'=' is not preceded with whitespace.` |
| 129 | 9 | `'for' is not followed by whitespace.` |
| 129 | 33 | `'{' is not preceded with whitespace.` |
| 130 | 13 | `'if' is not followed by whitespace.` |
| 130 | 30 | `'{' is not preceded with whitespace.` |
| 134 | 18 | `'wordsarray' hides a field.` |
| 134 | 28 | `'=' is not followed by whitespace.` |
| 134 | 28 | `'=' is not preceded with whitespace.` |
| 135 | 19 | `'=' is not followed by whitespace.` |
| 135 | 19 | `'=' is not preceded with whitespace.` |
### `DataAnalyzer.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 4 | 8 | `Unused import - cpen221.mp1.histogram.Histogram.` |
| 24 | 11 | `Found a TODO or FIXME comment` |
| 40 | 27 | `'map' hides a field.` |
| 56 | 82 | `'{' is not preceded with whitespace.` |
| 57 | 56 | `'{' is not preceded with whitespace.` |
| 71 | 23 | `Found a TODO or FIXME comment` |
| 90 | 44 | `'3' is a magic number.` |
| 94 | 28 | `'3.5' is a magic number.` |
### `SearchTerm.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 | None | `File does not end with a newline.` |
| 23 | 28 | `'=' is not preceded with whitespace.` |
| 51 | 27 | `'=' is not followed by whitespace.` |
| 51 | 27 | `'=' is not preceded with whitespace.` |
| 52 | 27 | `'=' is not followed by whitespace.` |
| 52 | 27 | `'=' is not preceded with whitespace.` |
| 92 | 9 | `'}' at column 9 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
### `SentimentAnalyzer.java`
| Line | Column | Message |
| ---- | ------ | ------- |
| 1 | None | `File does not end with a newline.` |
| 10 | 28 | `',' is not followed by whitespace.` |
| 10 | 39 | `',' is not followed by whitespace.` |
| 29 | 25 | `'=' is not followed by whitespace.` |
| 29 | 25 | `'=' is not preceded with whitespace.` |
| 29 | 47 | `'!=' is not followed by whitespace.` |
| 29 | 47 | `'!=' is not preceded with whitespace.` |
| 29 | 59 | `'=' is not followed by whitespace.` |
| 29 | 59 | `'=' is not preceded with whitespace.` |
| 30 | 39 | `'>=' is not followed by whitespace.` |
| 30 | 39 | `'>=' is not preceded with whitespace.` |
| 30 | 41 | `'3' is a magic number.` |
| 31 | 41 | `',' is not followed by whitespace.` |
| 31 | 42 | `'3' is a magic number.` |
| 51 | 22 | `',' is not followed by whitespace.` |
| 52 | 19 | `',' is not followed by whitespace.` |
| 76 | 15 | `Local variable 'prating_bag' must be in camelCase, or consist of a single upper-case letter.` |
| 78 | 28 | `'=' is not followed by whitespace.` |
| 78 | 28 | `'=' is not preceded with whitespace.` |
| 87 | 24 | `'=' is not followed by whitespace.` |
| 88 | 19 | `Local variable 'pbag_rating' must be in camelCase, or consist of a single upper-case letter.` |
| 88 | 31 | `'=' is not followed by whitespace.` |
| 89 | 17 | `Local variable 'occurrences_r' must be in camelCase, or consist of a single upper-case letter.` |
| 90 | 18 | `Local variable 'occurrences_w' must be in camelCase, or consist of a single upper-case letter.` |
| 91 | 18 | `Local variable 'occurrences_w_r' must be in camelCase, or consist of a single upper-case letter.` |
| 99 | 19 | `Local variable 'Pword' must be in camelCase, or consist of a single upper-case letter.` |
| 110 | 19 | `Local variable 'Pbr' must be in camelCase, or consist of a single upper-case letter.` |
| 110 | 22 | `'=' is not followed by whitespace.` |
| 110 | 22 | `'=' is not preceded with whitespace.` |
| 113 | 45 | `'typecast' is not followed by whitespace.` |
| 116 | 44 | `'==' is not followed by whitespace.` |
| 116 | 44 | `'==' is not preceded with whitespace.` |
| 117 | 51 | `'+' is not followed by whitespace.` |
| 117 | 51 | `'+' is not preceded with whitespace.` |
| 117 | 78 | `'+' is not followed by whitespace.` |
| 117 | 78 | `'+' is not preceded with whitespace.` |
| 118 | 17 | `'}' at column 17 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 129 | 29 | `'=' is not followed by whitespace.` |
| 130 | 23 | `'=' is not followed by whitespace.` |
| 130 | 23 | `'=' is not preceded with whitespace.` |
| 131 | 13 | `'}' at column 13 should be on the same line as the next part of a multi-block statement (one that directly contains multiple blocks: if/else-if/else, do/while or try/catch/finally).` |
| 133 | 29 | `'=' is not followed by whitespace.` |
| 134 | 27 | `'<' is not followed by whitespace.` |
| 134 | 27 | `'<' is not preceded with whitespace.` |
| 135 | 27 | `'=' is not followed by whitespace.` |
| 135 | 27 | `'=' is not preceded with whitespace.` |
| 152 | 34 | `'&&' is not followed by whitespace.` |
| 152 | 34 | `'&&' is not preceded with whitespace.` |

