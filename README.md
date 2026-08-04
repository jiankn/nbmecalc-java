# NBMEcalc Core for Java

A dependency-free Java 17 library that converts supported practice-exam inputs to an educational Step-score estimate and combines multiple inputs with an uncertainty interval.

The implementation is the reusable baseline behind the [free NBME score calculator](https://nbmecalc.com/), where NBME, UWSA, Free 120, AMBOSS, and CMS inputs can be combined into an independent planning estimate with a confidence interval. The library runs entirely offline and performs no tracking or network requests.

> This package is an independent educational planning tool. Its mappings are model assumptions, not official NBME, FSMB, USMLE, UWorld, AMBOSS, or CMS conversions. Do not use it for clinical decisions or as a guarantee of an examination result.

## Install

After the first Maven Central release:

```xml
<dependency>
  <groupId>io.github.jiankn</groupId>
  <artifactId>nbmecalc-core</artifactId>
  <version>1.0.0</version>
</dependency>
```

For local development before publication:

```shell
mvn clean install
```

## Example

```java
import io.github.jiankn.nbmecalc.PracticeExam;
import io.github.jiankn.nbmecalc.Prediction;
import io.github.jiankn.nbmecalc.ScorePredictor;
import io.github.jiankn.nbmecalc.StepKind;

import java.util.List;

var exams = List.of(
    PracticeExam.nbme(240, 30, 21),
    PracticeExam.uwsa2(250, 7),
    PracticeExam.free120(76, 2)
);

Prediction result = ScorePredictor.predict(exams, StepKind.STEP_2, 10);
System.out.printf("Estimate %d (%d-%d)%n",
    result.pointEstimate(), result.ciLower(), result.ciUpper());
```

## Supported inputs

- NBME three-digit practice scores, with optional form bias for forms 28-32
- UWSA 1 and UWSA 2 three-digit practice scores
- Free 120 and AMBOSS percentage scores
- CMS percentage or three-digit inputs, treated as lower-weight subject signals

The public API exposes single-input conversion through `ScoreConverter` and multi-input aggregation through `ScorePredictor`. Algorithm compatibility is identified by `Prediction.algorithmVersion()`.

## Development

```shell
mvn clean verify
mvn javadoc:javadoc
```

The test suite checks anchor interpolation, source adjustments, form bias, uncertainty widening, recency handling, and output bounds on Linux and Windows.

## License

Apache-2.0. The NBMEcalc name and product branding are not granted for unrelated products by the software license.
