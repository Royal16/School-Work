#include <Wire.h>
#include "DFRobot_RGBLCD.h"
#include "FastLED.h"

#define LED_PIN 7
#define NUM_LEDS 54

CRGB leds[NUM_LEDS];

int upButton = 10;
int downButton = 11;
int selectButton = 12;
int menu = 1;

const int colorR = 255;
const int colorG = 0;
const int colorB = 0;

DFRobot_RGBLCD lcd(16, 2);

void setup()
{
  lcd.init();
  lcd.setRGB(colorR, colorG, colorB);
  pinMode(upButton, INPUT_PULLUP);
  pinMode(downButton, INPUT_PULLUP);
  pinMode(selectButton, INPUT_PULLUP);
  Serial.begin(9600);
  pinMode(LED_PIN, OUTPUT);
  FastLED.addLeds<WS2812, LED_PIN, GRB>(leds, NUM_LEDS);
  updateMenu();
}

void loop() {
  if (!digitalRead(downButton)) {
    menu++;
    updateMenu();
    delay(100);
    while (!digitalRead(downButton));
  }
  if (!digitalRead(upButton)) {
    menu--;
    updateMenu();
    delay(100);
    while (!digitalRead(upButton));
  }
  if (!digitalRead(selectButton)) {
    executeAction();
    updateMenu();
    delay(100);
    while (!digitalRead(selectButton));
  }
}

void updateMenu() {
  switch (menu) {
    case 0:
      menu = 1;
      break;
    case 1:
      lcd.clear();
      lcd.print(">Fade");
      lcd.setCursor(0, 1);
      lcd.print(" Rainbow");
      break;
    case 2:
      lcd.clear();
      lcd.print(" Fade");
      lcd.setCursor(0, 1);
      lcd.print(">Rainbow");
      break;
    case 3:
      lcd.clear();
      lcd.print(" Rainbow");
      lcd.setCursor(0, 1);
      lcd.print(">Random Color");
      break;
    case 4:
      lcd.clear();
      lcd.print(" Random Color");
      lcd.setCursor(0, 1);
      lcd.print(">Stable Color");
      break;
    case 5:
      menu = 4;
      break;
  }
}
void executeAction() {
  switch (menu) {
    case 1:
      action1();
      break;
    case 2:
      action2();
      break;
    case 3:
      action3();
      break;
    case 4:
      action4();
      break;
  }
}

void action1() {
  lcd.clear();
  lcd.print(">Fade");
  delay(1000);
  for (int i = 0; i < 54; i++) {
    leds[i] = CRGB(0, 227, 229);
    delay(15);
  }
  FastLED.show();
  for (int i = 0; i < 54; i++) {
    leds[i] = CRGB(47, 232, 127);
    delay(15);
  }
  FastLED.show();
  for (int i = 0; i < 54; i++) {
    leds[i] = CRGB(107, 239, 1);
    delay(15);
  }
  FastLED.show();
}
void action2() {
  lcd.clear();
  lcd.print(">Rainbow");
  delay(1500);
}
void action3() {
  lcd.clear();
  lcd.print(">Random Color");
  delay(1500);
}
void action4() {
  lcd.clear();
  lcd.print(">Stable Color");
  delay(1500);
}


