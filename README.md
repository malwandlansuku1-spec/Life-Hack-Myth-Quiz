# Life Hack or Urban Myth? - IMAD5112 wA2

**Module:** IMAD5112 - Native Android App in Kotlin
**Objective:** Flashcard game to help users distinguish genuine productivity tips from viral urban myths.

## Features
- Welcome Screen with description and Start button (Requirement 1.1)
- Flashcard Question Screen with loop through 5 questions, Hack/Myth buttons, Next button, feedback (Requirement 1.2)
- Score Screen with total correct, personalized feedback (Master Hacker / Stay Safe Online), Review button (Requirement 1.3)
- Application Logic: loop iteration, score counter, navigation
- GitHub Actions automated build - Passing ✅

## How it Works
1. Welcome -> Click Start
2. For each of 5 flashcards: Read statement -> Click Hack or Myth -> See feedback (Correct!/Wrong! + explanation) -> Click Next
3. After last question -> Score Screen shows total score and message based on score
4. Click Review to see all statements with correct explanations

## GitHub Actions
Using GitHub Actions workflow to verify build on every push. Status: Passing
