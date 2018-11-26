#pragma once
#include "../JuceLibraryCode/JuceHeader.h"

class Logex : public Component
{
public:
	Logex() : searchBtn("search"), clearBtn("clear")
	{
		addAndMakeVisible(backgroundLabel);
		addAndMakeVisible(inputLabel);
		addAndMakeVisible(searchBtn);
		addAndMakeVisible(clearBtn);

		backgroundLabel.setFont(Font(20.0f, Font::bold));
		backgroundLabel.setText("Input Expression:", dontSendNotification);
		backgroundLabel.setColour(Label::textColourId, Colours::black);
		backgroundLabel.setColour(Label::backgroundColourId, Colours::deeppink);

		inputLabel.setEditable(true);
		inputLabel.setColour(Label::backgroundColourId, Colours::white);
		inputLabel.setColour(Label::textWhenEditingColourId, Colours::black);
		inputLabel.setColour(Label::outlineWhenEditingColourId, Colours::blue);
		inputLabel.setColour(Label::backgroundWhenEditingColourId, Colours::blue);

		searchBtn.setColour(TextButton::buttonColourId, Colours::cyan);
		searchBtn.setColour(TextButton::textColourOffId, Colours::black);
		searchBtn.setColour(TextButton::textColourOnId, Colours::black);

		clearBtn.setColour(TextButton::buttonColourId, Colours::cyan);
		clearBtn.setColour(TextButton::textColourOffId, Colours::black);
		clearBtn.setColour(TextButton::textColourOnId, Colours::black);


	}
	~Logex(){}
	void paint(Graphics& g) override{
		
	}
	void resized() override{
		int label_height = 50;
		backgroundLabel.setBounds(0, 0, getWidth(), label_height);
		inputLabel.setBounds(180, 10, 250, 30);
		searchBtn.setBounds(440, 10, 70, 30);
		clearBtn.setBounds(520, 10, 70, 30);

	}
private:
	Label backgroundLabel, inputLabel;
	TextButton searchBtn, clearBtn;
	JUCE_DECLARE_NON_COPYABLE_WITH_LEAK_DETECTOR(Logex);
};