package utilities;

import com.sun.xml.internal.ws.api.message.MessageWritable;
import com.sun.xml.internal.ws.api.pipe.ThrowableContainerPropertySet;
import exception.InvalidNoteException;
import org.jcp.xml.dsig.internal.dom.DOMTransform;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * This is the contract specification for a musical pitch or note.
 * A pitch can be completely specified as one of the following:
 * 1. A number of cycles per second or frequency.
 * 2. The number of half steps above a commonly agreed upon pitch
 * (concert pitch=440Hz = A = MIDI69) or
 * 3. The common music note name (C, D, E, F, G, A, B) with the
 * the suffix indicating the octave number [-1,9] and an additional
 * suffix prefix '#' for sharp notes and 'b' for flat notes or
 * 4. The MIDI absolute note number [0,127] where 60 is middle C.
 * <p>
 * Higher pitches have higher frequencies. Two pitches are an octave apart
 * (12 semitones) if one frequency is twice the other. A semitone is
 * aproximately an increase in pitch of 1.06 times higher.
 */

public abstract class NoteADT implements Comparable<NoteADT>
{


    protected int midiNoteValue = -1;

    /**
     * A semitone is aproximately an increase in pitch of 1.06 times higher.
     */
    public static final double SEMI_TONE_INCREASE_IN_PITCH = Math.pow(2.0, 1.0 / 12.0);
    /**
     * The agreed upon pitch "modern concert pitch"
     */
    public static final double HZ_CONCERT_PITCH = 440.0; //Hz
    public static final int MIDI_CONCERT_PITCH = 69;

    /**
     * The high and low limits on the range of midi numbers.
     */
    public static final int LOW_MIDI_ABSOLUTE_NUMBER = 0;
    public static final int HIGH_MIDI_ABSOLUTE_NUMBER = 127;


    /**
     * The constructors for a note accept a frequency as a double for Hz or
     * a number of semitones as an int above or below the concert pitch (440Hz)
     * or a music note as a String such as C#4
     * Imperfect frequencies are tuned to the nearest half pitch
     * Notes that are outside the range of 0 - 127 are invalid
     * notes and the InvalidNoteException is raised.
     */

    public NoteADT(double frequency) throws InvalidNoteException
    {
        //You must provide the code here for this constructor

        double[] midi = new double[HIGH_MIDI_ABSOLUTE_NUMBER];
        double a = HZ_CONCERT_PITCH; // a is 440 hz...
        for (int x = 0; x < 127; ++x) {

            double aaa = (a / 32);
            double ccc = x - 9;
            double bbb = Math.pow(2, ccc / 12);

            midi[x] = aaa * bbb;

            double roundedNearestHalf = Math.round(midi[x] - 0.5) + 0.5;

            double frequencyRounded = Math.round(frequency - 0.5) + 0.5;

            if (roundedNearestHalf == frequencyRounded) {
                this.midiNoteValue = x;
            }

        }


    }

    public NoteADT(int semitones) throws InvalidNoteException
    {
        //You must provide the code here for this constructor

        double kkz = semitones / 12.0;
        double aac = Math.pow(2.0, kkz);
        double frequency = HZ_CONCERT_PITCH * aac;

        double[] midi = new double[HIGH_MIDI_ABSOLUTE_NUMBER];
        double a = HZ_CONCERT_PITCH; // a is 440 hz...
        for (int x = 0; x < 127; ++x) {

            double aaa = (a / 32);
            double ccc = x - 9;
            double bbb = Math.pow(2, ccc / 12);

            midi[x] = aaa * bbb;

            double roundedNearestHalf = Math.round(midi[x] - 0.5) + 0.5;

            double frequencyRounded = Math.round(frequency - 0.5) + 0.5;

            if (roundedNearestHalf == frequencyRounded) {
                this.midiNoteValue = x;
            }

        }

    }

    public NoteADT(String strNote) throws InvalidNoteException
    {
        //You must provide the code here for this constructor


        if (strNote.toUpperCase().equals("C-1")) {
            midiNoteValue = 0;

        }
        if (strNote.toUpperCase().equals("C0")) {
            midiNoteValue = 12;

        }
        if (strNote.toUpperCase().equals("C1")) {
            midiNoteValue = 24;

        }
        if (strNote.toUpperCase().equals("C2")) {
            midiNoteValue = 36;

        }
        if (strNote.toUpperCase().equals("C3")) {
            midiNoteValue = 48;

        }
        if (strNote.toUpperCase().equals("C4")) {
            midiNoteValue = 60;

        }
        if (strNote.toUpperCase().equals("C5")) {
            midiNoteValue = 72;

        }
        if (strNote.toUpperCase().equals("C6")) {
            midiNoteValue = 84;

        }
        if (strNote.toUpperCase().equals("C7")) {
            midiNoteValue = 96;

        }
        if (strNote.toUpperCase().equals("C8")) {
            midiNoteValue = 108;

        }
        if (strNote.toUpperCase().equals("C9")) {
            midiNoteValue = 120;

        }
        if (strNote.toUpperCase().equals("C#-1") || strNote.toUpperCase().equals("C-1#")) {
            midiNoteValue = 1;

        }
        if (strNote.toUpperCase().equals("C#0") || strNote.toUpperCase().equals("C0#")) {
            midiNoteValue = 13;

        }
        if (strNote.toUpperCase().equals("C#1") || strNote.toUpperCase().equals("C1#")) {
            midiNoteValue = 25;

        }
        if (strNote.toUpperCase().equals("C#2") || strNote.toUpperCase().equals("C2#")) {
            midiNoteValue = 37;

        }
        if (strNote.toUpperCase().equals("C#3")|| strNote.toUpperCase().equals("C3#")) {
            midiNoteValue = 49;

        }
        if (strNote.toUpperCase().equals("C#4")|| strNote.toUpperCase().equals("C4#")) {
            midiNoteValue = 61;

        }
        if (strNote.toUpperCase().equals("C#5")|| strNote.toUpperCase().equals("C5#")) {
            midiNoteValue = 73;

        }
        if (strNote.toUpperCase().equals("C#6")|| strNote.toUpperCase().equals("C6#")) {
            midiNoteValue = 85;

        }
        if (strNote.toUpperCase().equals("C#7")|| strNote.toUpperCase().equals("C7#")) {
            midiNoteValue = 97;

        }
        if (strNote.toUpperCase().equals("C#8")|| strNote.toUpperCase().equals("C8#")) {
            midiNoteValue = 109;

        }
        if (strNote.toUpperCase().equals("C#9")|| strNote.toUpperCase().equals("C9#")) {
            midiNoteValue = 121;

        }
        if (strNote.toUpperCase().equals("CB0") || strNote.toUpperCase().equals("C0B")) {
           midiNoteValue=11;

        }
        if (strNote.toUpperCase().equals("CB1") || strNote.toUpperCase().equals("C1B")) {
            midiNoteValue=23;

        }
        if (strNote.toUpperCase().equals("CB2") || strNote.toUpperCase().equals("C2B")) {
            midiNoteValue=35;

        }
        if (strNote.toUpperCase().equals("CB3") || strNote.toUpperCase().equals("C3B")) {
            midiNoteValue=47;

        }
        if (strNote.toUpperCase().equals("CB4") || strNote.toUpperCase().equals("C4B")) {
            midiNoteValue=59;

        }
        if (strNote.toUpperCase().equals("CB5") || strNote.toUpperCase().equals("C5B")) {
            midiNoteValue=71;

        }
        if (strNote.toUpperCase().equals("CB6") || strNote.toUpperCase().equals("C6B")) {
            midiNoteValue=83;

        }
        if (strNote.toUpperCase().equals("CB7") || strNote.toUpperCase().equals("C7B")) {
            midiNoteValue=95;

        }
        if (strNote.toUpperCase().equals("CB8") || strNote.toUpperCase().equals("C8B")) {
            midiNoteValue=107;

        }
        if (strNote.toUpperCase().equals("CB9") || strNote.toUpperCase().equals("C9B")) {
            midiNoteValue=119;

        }

        if (strNote.toUpperCase().equals("D-1")) {
            midiNoteValue = 2;

        }
        if (strNote.toUpperCase().equals("D0")) {
            midiNoteValue = 14;

        }
        if (strNote.toUpperCase().equals("D1")) {
            midiNoteValue = 26;

        }
        if (strNote.toUpperCase().equals("D2")) {
            midiNoteValue = 38;

        }
        if (strNote.toUpperCase().equals("D3")) {
            midiNoteValue = 50;

        }
        if (strNote.toUpperCase().equals("D4")) {
            midiNoteValue = 62;

        }
        if (strNote.toUpperCase().equals("D5")) {
            midiNoteValue = 74;

        }
        if (strNote.toUpperCase().equals("D6")) {
            midiNoteValue = 86;

        }
        if (strNote.toUpperCase().equals("D7")) {
            midiNoteValue = 98;

        }
        if (strNote.toUpperCase().equals("D8")) {
            midiNoteValue = 110;

        }
        if (strNote.toUpperCase().equals("D9")) {
            midiNoteValue = 122;

        }
        if (strNote.toUpperCase().equals("D#-1") || strNote.toUpperCase().equals("D-1#")) {
            midiNoteValue = 3;

        }
        if (strNote.toUpperCase().equals("D#0") || strNote.toUpperCase().equals("D0#")) {
            midiNoteValue = 15;

        }
        if (strNote.toUpperCase().equals("D#1") || strNote.toUpperCase().equals("D1#")) {
            midiNoteValue = 27;

        }
        if (strNote.toUpperCase().equals("D#2") || strNote.toUpperCase().equals("D2#")) {
            midiNoteValue = 39;

        }
        if (strNote.toUpperCase().equals("D#3")|| strNote.toUpperCase().equals("D3#")) {
            midiNoteValue = 51;

        }
        if (strNote.toUpperCase().equals("D#4")|| strNote.toUpperCase().equals("D4#")) {
            midiNoteValue = 63;

        }
        if (strNote.toUpperCase().equals("D#5")|| strNote.toUpperCase().equals("D5#")) {
            midiNoteValue = 75;

        }
        if (strNote.toUpperCase().equals("D#6")|| strNote.toUpperCase().equals("D6#")) {
            midiNoteValue = 87;

        }
        if (strNote.toUpperCase().equals("D#7")|| strNote.toUpperCase().equals("D7#")) {
            midiNoteValue = 99;

        }
        if (strNote.toUpperCase().equals("D#8")|| strNote.toUpperCase().equals("D8#")) {
            midiNoteValue = 111;

        }
        if (strNote.toUpperCase().equals("D#9")|| strNote.toUpperCase().equals("D9#")) {
            midiNoteValue = 123;

        }
        if (strNote.toUpperCase().equals("DB-1") || strNote.toUpperCase().equals("D-1B")) {
            midiNoteValue = 1;

        }
        if (strNote.toUpperCase().equals("DB0") || strNote.toUpperCase().equals("D0B")) {
            midiNoteValue=13;

        }
        if (strNote.toUpperCase().equals("DB1") || strNote.toUpperCase().equals("D1B")) {
            midiNoteValue=25;

        }
        if (strNote.toUpperCase().equals("DB2") || strNote.toUpperCase().equals("D2B")) {
            midiNoteValue=37;

        }
        if (strNote.toUpperCase().equals("DB3") || strNote.toUpperCase().equals("D3B")) {
            midiNoteValue=49;

        }
        if (strNote.toUpperCase().equals("DB4") || strNote.toUpperCase().equals("D4B")) {
            midiNoteValue=61;

        }
        if (strNote.toUpperCase().equals("DB5") || strNote.toUpperCase().equals("D5B")) {
            midiNoteValue=73;

        }
        if (strNote.toUpperCase().equals("DB6") || strNote.toUpperCase().equals("D6B")) {
            midiNoteValue=85;

        }
        if (strNote.toUpperCase().equals("DB7") || strNote.toUpperCase().equals("D7B")) {
            midiNoteValue=97;

        }
        if (strNote.toUpperCase().equals("DB8") || strNote.toUpperCase().equals("D8B")) {
            midiNoteValue=109;

        }
        if (strNote.toUpperCase().equals("DB9") || strNote.toUpperCase().equals("D9B")) {
            midiNoteValue=121;

        }
        if (strNote.toUpperCase().equals("E-1")) {
            midiNoteValue = 4;

        }
        if (strNote.toUpperCase().equals("E0")) {
            midiNoteValue = 16;

        }
        if (strNote.toUpperCase().equals("E1")) {
            midiNoteValue = 28;

        }
        if (strNote.toUpperCase().equals("E2")) {
            midiNoteValue = 40;

        }
        if (strNote.toUpperCase().equals("E3")) {
            midiNoteValue = 52;

        }
        if (strNote.toUpperCase().equals("E4")) {
            midiNoteValue = 64;

        }
        if (strNote.toUpperCase().equals("E5")) {
            midiNoteValue = 76;

        }
        if (strNote.toUpperCase().equals("E6")) {
            midiNoteValue = 88;

        }
        if (strNote.toUpperCase().equals("E7")) {
            midiNoteValue = 100;

        }
        if (strNote.toUpperCase().equals("E8")) {
            midiNoteValue = 112;

        }
        if (strNote.toUpperCase().equals("E9")) {
            midiNoteValue = 124;

        }
        if (strNote.toUpperCase().equals("EB-1") || strNote.toUpperCase().equals("E-1B")) {
            midiNoteValue = 3;

        }
        if (strNote.toUpperCase().equals("EB0") || strNote.toUpperCase().equals("E0B")) {
            midiNoteValue = 15;

        }
        if (strNote.toUpperCase().equals("EB1") || strNote.toUpperCase().equals("E1B")) {
            midiNoteValue = 27;

        }
        if (strNote.toUpperCase().equals("EB2") || strNote.toUpperCase().equals("E2B")) {
            midiNoteValue = 39;

        }
        if (strNote.toUpperCase().equals("EB3") || strNote.toUpperCase().equals("E3B")) {
            midiNoteValue = 51;

        }
        if (strNote.toUpperCase().equals("EB4") || strNote.toUpperCase().equals("E4B")) {
            midiNoteValue = 63;

        }
        if (strNote.toUpperCase().equals("EB5") || strNote.toUpperCase().equals("E5B")) {
            midiNoteValue = 75;

        }
        if (strNote.toUpperCase().equals("EB6") || strNote.toUpperCase().equals("E6B")) {
            midiNoteValue = 87;

        }
        if (strNote.toUpperCase().equals("EB7") || strNote.toUpperCase().equals("E7B")) {
            midiNoteValue = 99;

        }
        if (strNote.toUpperCase().equals("EB8") || strNote.toUpperCase().equals("E8B")) {
            midiNoteValue = 111;

        }
        if (strNote.toUpperCase().equals("EB9") || strNote.toUpperCase().equals("E9B")) {
            midiNoteValue = 123;

        }
        if (strNote.toUpperCase().equals("F-1")) {
            midiNoteValue = 5;

        }
        if (strNote.toUpperCase().equals("F0")) {
            midiNoteValue = 17;

        }
        if (strNote.toUpperCase().equals("F1")) {
            midiNoteValue = 29;

        }
        if (strNote.toUpperCase().equals("F2")) {
            midiNoteValue = 41;

        }
        if (strNote.toUpperCase().equals("F3")) {
            midiNoteValue = 53;

        }
        if (strNote.toUpperCase().equals("F4")) {
            midiNoteValue = 65;

        }
        if (strNote.toUpperCase().equals("F5")) {
            midiNoteValue = 77;

        }
        if (strNote.toUpperCase().equals("F6")) {
            midiNoteValue = 89;

        }
        if (strNote.toUpperCase().equals("F7")) {
            midiNoteValue = 101;

        }
        if (strNote.toUpperCase().equals("F8")) {
            midiNoteValue = 113;

        }
        if (strNote.toUpperCase().equals("F9")) {
            midiNoteValue = 125;

        }
        if (strNote.toUpperCase().equals("FB-1") || strNote.toUpperCase().equals("F-1B")) {
            midiNoteValue = 4;

        }
        if (strNote.toUpperCase().equals("FB0") || strNote.toUpperCase().equals("F0B")) {
            midiNoteValue = 16;

        }
        if (strNote.toUpperCase().equals("FB1") || strNote.toUpperCase().equals("F1B")) {
            midiNoteValue = 28;

        }
        if (strNote.toUpperCase().equals("FB2") || strNote.toUpperCase().equals("F2B")) {
            midiNoteValue = 40;

        }
        if (strNote.toUpperCase().equals("FB3") || strNote.toUpperCase().equals("F3B")) {
            midiNoteValue = 52;

        }
        if (strNote.toUpperCase().equals("FB4") || strNote.toUpperCase().equals("F4B")) {
            midiNoteValue = 64;

        }
        if (strNote.toUpperCase().equals("FB5") || strNote.toUpperCase().equals("F5B")) {
            midiNoteValue = 76;

        }
        if (strNote.toUpperCase().equals("FB6") || strNote.toUpperCase().equals("F6B")) {
            midiNoteValue = 88;

        }
        if (strNote.toUpperCase().equals("FB7") || strNote.toUpperCase().equals("F7B")) {
            midiNoteValue = 100;

        }
        if (strNote.toUpperCase().equals("FB8") || strNote.toUpperCase().equals("F8B")) {
            midiNoteValue = 112;

        }
        if (strNote.toUpperCase().equals("FB9") || strNote.toUpperCase().equals("F9B")) {
            midiNoteValue = 124;

        }
        if (strNote.toUpperCase().equals("F#-1") || strNote.toUpperCase().equals("F-1#")) {
            midiNoteValue = 6;

        }
        if (strNote.toUpperCase().equals("F#0") || strNote.toUpperCase().equals("F0#")) {
            midiNoteValue = 18;

        }
        if (strNote.toUpperCase().equals("F#1") || strNote.toUpperCase().equals("F1#")) {
            midiNoteValue = 30;

        }
        if (strNote.toUpperCase().equals("F#2") || strNote.toUpperCase().equals("F2#")) {
            midiNoteValue = 42;

        }
        if (strNote.toUpperCase().equals("F#3")|| strNote.toUpperCase().equals("F3#")) {
            midiNoteValue = 54;

        }
        if (strNote.toUpperCase().equals("F#4")|| strNote.toUpperCase().equals("F4#")) {
            midiNoteValue = 66;

        }
        if (strNote.toUpperCase().equals("F#5")|| strNote.toUpperCase().equals("F5#")) {
            midiNoteValue = 78;

        }
        if (strNote.toUpperCase().equals("F#6")|| strNote.toUpperCase().equals("F6#")) {
            midiNoteValue = 90;

        }
        if (strNote.toUpperCase().equals("F#7")|| strNote.toUpperCase().equals("F7#")) {
            midiNoteValue = 102;

        }
        if (strNote.toUpperCase().equals("F#8")|| strNote.toUpperCase().equals("F8#")) {
            midiNoteValue = 114;

        }
        if (strNote.toUpperCase().equals("F#9")|| strNote.toUpperCase().equals("F9#")) {
            midiNoteValue = 126;

        }
        if (strNote.toUpperCase().equals("G-1")) {
            midiNoteValue = 7;

        }
        if (strNote.toUpperCase().equals("G0")) {
            midiNoteValue = 19;

        }
        if (strNote.toUpperCase().equals("G1")) {
            midiNoteValue = 31;

        }
        if (strNote.toUpperCase().equals("G2")) {
            midiNoteValue = 43;

        }
        if (strNote.toUpperCase().equals("G3")) {
            midiNoteValue = 55;

        }
        if (strNote.toUpperCase().equals("G4")) {
            midiNoteValue = 67;

        }
        if (strNote.toUpperCase().equals("G5")) {
            midiNoteValue = 79;

        }
        if (strNote.toUpperCase().equals("G6")) {
            midiNoteValue = 91;

        }
        if (strNote.toUpperCase().equals("G7")) {
            midiNoteValue = 103;

        }
        if (strNote.toUpperCase().equals("G8")) {
            midiNoteValue = 115;

        }
        if (strNote.toUpperCase().equals("G9")) {
            midiNoteValue = 127;

        }
        if (strNote.toUpperCase().equals("G#-1") || strNote.toUpperCase().equals("G-1#")) {
            midiNoteValue = 8;

        }
        if (strNote.toUpperCase().equals("G#0") || strNote.toUpperCase().equals("G0#")) {
            midiNoteValue = 20;

        }
        if (strNote.toUpperCase().equals("G#1") || strNote.toUpperCase().equals("G1#")) {
            midiNoteValue = 32;

        }
        if (strNote.toUpperCase().equals("G#2") || strNote.toUpperCase().equals("G2#")) {
            midiNoteValue = 44;

        }
        if (strNote.toUpperCase().equals("G#3")|| strNote.toUpperCase().equals("G3#")) {
            midiNoteValue = 56;

        }
        if (strNote.toUpperCase().equals("G#4")|| strNote.toUpperCase().equals("G4#")) {
            midiNoteValue = 68;

        }
        if (strNote.toUpperCase().equals("G#5")|| strNote.toUpperCase().equals("G5#")) {
            midiNoteValue = 80;

        }
        if (strNote.toUpperCase().equals("F#6")|| strNote.toUpperCase().equals("F6#")) {
            midiNoteValue = 92;

        }
        if (strNote.toUpperCase().equals("G#7")|| strNote.toUpperCase().equals("G7#")) {
            midiNoteValue = 104;

        }
        if (strNote.toUpperCase().equals("G#8")|| strNote.toUpperCase().equals("G8#")) {
            midiNoteValue = 116;

        }
        if (strNote.toUpperCase().equals("GB-1") || strNote.toUpperCase().equals("G-1B")) {
            midiNoteValue = 6;

        }
        if (strNote.toUpperCase().equals("GB0") || strNote.toUpperCase().equals("G0B")) {
            midiNoteValue = 18;

        }
        if (strNote.toUpperCase().equals("GB1") || strNote.toUpperCase().equals("G1B")) {
            midiNoteValue = 30;

        }
        if (strNote.toUpperCase().equals("GB2") || strNote.toUpperCase().equals("G2B")) {
            midiNoteValue = 42;

        }
        if (strNote.toUpperCase().equals("GB3") || strNote.toUpperCase().equals("G3B")) {
            midiNoteValue = 54;

        }
        if (strNote.toUpperCase().equals("GB4") || strNote.toUpperCase().equals("G4B")) {
            midiNoteValue = 66;

        }
        if (strNote.toUpperCase().equals("GB5") || strNote.toUpperCase().equals("G5B")) {
            midiNoteValue = 78;

        }
        if (strNote.toUpperCase().equals("GB6") || strNote.toUpperCase().equals("G6B")) {
            midiNoteValue = 90;

        }
        if (strNote.toUpperCase().equals("GB7") || strNote.toUpperCase().equals("G7B")) {
            midiNoteValue = 102;

        }
        if (strNote.toUpperCase().equals("GB8") || strNote.toUpperCase().equals("G8B")) {
            midiNoteValue = 114;

        }
        if (strNote.toUpperCase().equals("GB9") || strNote.toUpperCase().equals("G9B")) {
            midiNoteValue = 126;

        }
        if (strNote.toUpperCase().equals("A-1")) {
            midiNoteValue = 9;

        }
        if (strNote.toUpperCase().equals("A0")) {
            midiNoteValue = 21;

        }
        if (strNote.toUpperCase().equals("A1")) {
            midiNoteValue = 33;

        }
        if (strNote.toUpperCase().equals("A2")) {
            midiNoteValue = 45;

        }
        if (strNote.toUpperCase().equals("A3")) {
            midiNoteValue = 57;

        }
        if (strNote.toUpperCase().equals("A4")) {
            midiNoteValue = 69;

        }
        if (strNote.toUpperCase().equals("A5")) {
            midiNoteValue = 81;

        }
        if (strNote.toUpperCase().equals("A6")) {
            midiNoteValue = 93;

        }
        if (strNote.toUpperCase().equals("A7")) {
            midiNoteValue = 105;

        }
        if (strNote.toUpperCase().equals("A8")) {
            midiNoteValue = 117;

        }
        if (strNote.toUpperCase().equals("A#-1") || strNote.toUpperCase().equals("A-1#")) {
            midiNoteValue = 10;

        }
        if (strNote.toUpperCase().equals("A#0") || strNote.toUpperCase().equals("A0#")) {
            midiNoteValue = 22;

        }
        if (strNote.toUpperCase().equals("A#1") || strNote.toUpperCase().equals("A1#")) {
            midiNoteValue = 34;

        }
        if (strNote.toUpperCase().equals("A#2") || strNote.toUpperCase().equals("A2#")) {
            midiNoteValue = 46;

        }
        if (strNote.toUpperCase().equals("A#3")|| strNote.toUpperCase().equals("A3#")) {
            midiNoteValue = 58;

        }
        if (strNote.toUpperCase().equals("A#4")|| strNote.toUpperCase().equals("A4#")) {
            midiNoteValue = 70;

        }
        if (strNote.toUpperCase().equals("A#5")|| strNote.toUpperCase().equals("A5#")) {
            midiNoteValue = 82;

        }
        if (strNote.toUpperCase().equals("A#6")|| strNote.toUpperCase().equals("A6#")) {
            midiNoteValue = 94;

        }
        if (strNote.toUpperCase().equals("A#7")|| strNote.toUpperCase().equals("A7#")) {
            midiNoteValue = 106;

        }
        if (strNote.toUpperCase().equals("A#8")|| strNote.toUpperCase().equals("A8#")) {
            midiNoteValue = 118;

        }
        if (strNote.toUpperCase().equals("AB-1") || strNote.toUpperCase().equals("A-1B")) {
            midiNoteValue = 8;

        }
        if (strNote.toUpperCase().equals("AB0") || strNote.toUpperCase().equals("A0B")) {
            midiNoteValue = 20;

        }
        if (strNote.toUpperCase().equals("AB1") || strNote.toUpperCase().equals("A1B")) {
            midiNoteValue = 32;

        }
        if (strNote.toUpperCase().equals("AB2") || strNote.toUpperCase().equals("A2B")) {
            midiNoteValue = 44;

        }
        if (strNote.toUpperCase().equals("AB3") || strNote.toUpperCase().equals("A3B")) {
            midiNoteValue = 56;

        }
        if (strNote.toUpperCase().equals("AB4") || strNote.toUpperCase().equals("A4B")) {
            midiNoteValue = 68;

        }
        if (strNote.toUpperCase().equals("AB5") || strNote.toUpperCase().equals("A5B")) {
            midiNoteValue = 80;

        }
        if (strNote.toUpperCase().equals("AB6") || strNote.toUpperCase().equals("A6B")) {
            midiNoteValue = 92;

        }
        if (strNote.toUpperCase().equals("AB7") || strNote.toUpperCase().equals("A7B")) {
            midiNoteValue = 104;

        }
        if (strNote.toUpperCase().equals("AB8") || strNote.toUpperCase().equals("A8B")) {
            midiNoteValue = 116;

        }
        if (strNote.toUpperCase().equals("B-1")) {
            midiNoteValue = 11;

        }
        if (strNote.toUpperCase().equals("B0")) {
            midiNoteValue = 23;

        }
        if (strNote.toUpperCase().equals("B1")) {
            midiNoteValue = 35;

        }
        if (strNote.toUpperCase().equals("B2")) {
            midiNoteValue = 47;

        }
        if (strNote.toUpperCase().equals("B3")) {
            midiNoteValue = 59;

        }
        if (strNote.toUpperCase().equals("B4")) {
            midiNoteValue = 71;

        }
        if (strNote.toUpperCase().equals("B5")) {
            midiNoteValue = 83;

        }
        if (strNote.toUpperCase().equals("B6")) {
            midiNoteValue = 95;

        }
        if (strNote.toUpperCase().equals("B7")) {
            midiNoteValue = 107;

        }
        if (strNote.toUpperCase().equals("B8")) {
            midiNoteValue = 119;

        }
        if (strNote.toUpperCase().equals("BB-1") || strNote.toUpperCase().equals("B-1B")) {
            midiNoteValue = 10;

        }
        if (strNote.toUpperCase().equals("BB0") || strNote.toUpperCase().equals("B0B")) {
            midiNoteValue = 22;

        }
        if (strNote.toUpperCase().equals("BB1") || strNote.toUpperCase().equals("B1B")) {
            midiNoteValue = 34;

        }
        if (strNote.toUpperCase().equals("BB2") || strNote.toUpperCase().equals("B2B")) {
            midiNoteValue = 46;

        }
        if (strNote.toUpperCase().equals("BB3") || strNote.toUpperCase().equals("B3B")) {
            midiNoteValue = 58;

        }
        if (strNote.toUpperCase().equals("BB4") || strNote.toUpperCase().equals("B4B")) {
            midiNoteValue = 70;

        }
        if (strNote.toUpperCase().equals("BB5") || strNote.toUpperCase().equals("B5B")) {
            midiNoteValue = 82;

        }
        if (strNote.toUpperCase().equals("BB6") || strNote.toUpperCase().equals("B6B")) {
            midiNoteValue = 94;

        }
        if (strNote.toUpperCase().equals("BB7") || strNote.toUpperCase().equals("B7B")) {
            midiNoteValue = 106;

        }
        if (strNote.toUpperCase().equals("BB8") || strNote.toUpperCase().equals("B8B")) {
            midiNoteValue = 118;

        }
        
        
        






    }

    /**
     * Returns the frequency of this note in cycles per second- Hertz (Hz)
     * <p>
     * Preconditions: A valid internal reference number exists for a note
     * and the numbers range from 0 (C-1) to 127 (G9).
     * <p>
     * Postconditions: The internal reference number is successfully converted
     * to a frequency in hertz and returned to the calling function.
     *
     * @return double The frequency in Hz.
     */
    public abstract double getFrequencyInHz();

    /**
     * Returns the frequency of this note in semitones (half steps) above or below
     * the concert pitch (440Hz).
     * <p>
     * Preconditions: A valid internal reference number exists for a note
     * and the numbers range from 0 (C-1) to 127 (G9).
     * <p>
     * Postconditions: The internal reference number is successfully converted
     * to number of half steps or semitones above or below concert pitch (69)
     * and returned to the calling function.
     *
     * @return int The frequency in Semitones or half steps
     */
    public abstract int getHalfSteps();

    /**
     * Returns the frequency of this note as a MIDI absolute Number.
     * <p>
     * Preconditions: A valid internal reference number exists for a note
     * and the numbers range from 0 (C-1) to 127 (G9).
     * <p>
     * Postconditions: The internal reference number is successfully returned
     * as the MIDI absolute Number to the calling function.
     *
     * @return int The frequency MIDI absolute Number
     */
    public abstract int getMIDIAbsoluteNumber();

    /**
     * Method compares if this note is 12 semitones above or
     * 12 semitones below the other note, then the notes form an octave.
     * <p>
     * Preconditions: A valid internal reference number exists and the note
     * passed into the method is a valid Note.
     * <p>
     * Postconditions: An octave is formed if the note passed in is exactly
     * 12 semitones above or below the internal reference MIDI absolute number.
     * If the difference is + or - 12 semitones then a boolean true is returned
     * otherwise a boolean false is returned.
     *
     * @param note The note that can form an Octave
     * @return boolean true if they do form an octave
     */
    public abstract boolean formOctave(NoteADT note);

    /**
     * Raise or lower the pitch by any number of semitones.
     * <p>
     * Preconditions: A valid internal reference number exists for a note
     * and the numbers range from 0 (C-1) to 127 (G9).
     * <p>
     * Postconditions: The internal reference MIDI absolute number is
     * increased or decreased by the amount of the semitones passed into
     * the method.
     *
     * @param numberOfSemitones Change int used to calculate the new note
     */
    public abstract void modifyNoteBySemitones(int numberOfSemitones);

    /**
     * The compareTo method will be implemented by the Comparable interface
     * it will adhere to the Comparable interface contract referenced in
     * the Java API - java.lang.*; and will have the following signature.
     * public int comparteTo(NoteADT note);.
     */
    public abstract int compareTo(NoteADT note);

}