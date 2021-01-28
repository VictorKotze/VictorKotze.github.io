import javax.sound.midi.*;
import javax.swing.*;

public class Music{

    public static void main(String[] args) throws InterruptedException{ 
        
        // key modifiers
        int k = 0;// key (Ex: c/c#)
        int hm = 0;// harmonic (raise 7)
        int m = 0;// minor (-1)
        int ml = 0;// melodic minor (+ 1 on 6/7)
        
        // c
        int c4 = 48;
        int c5 = 60;
        int c6 = 72;
        int c7 = 84;
        // d
        int d4= 50;
        int d5= 62;
        int d6 = 74;
        // e
        int e4 = 52;
        int e5 = 64;
        int e6= 76;
        // f
        int f4 = 53;
        int f5 = 65;
        int f6 = 77;
        // g
        int g4 = 55;
        int g5 = 67;
        int g6 = 79;
        // a
        int a4 = 57;
        int a5 = 69;
        int a6 = 81;
        // b
        int b4 = 59;
        int b5 = 71;
        int b6 = 83;
        
        // note vaues
        int s = 125;//16th
        int e = 250;//8th
        int q = 500;//quarter
        int h = 1000;//half
        int w = 2000;//whole
        
        String input = JOptionPane.showInputDialog("Enter a music key (key (minor type) major/minor)");
        
		if(input == null){
            System.exit(0);
		}
		
        input = input.toLowerCase();//convert input to all lower-case for ease of searching
        
        // majors
            
        if (input.indexOf("c major") !=-1 || input.indexOf("b# major") !=-1){
            k = 0;
        }else if(input.indexOf("c# major") !=-1 || input.indexOf("db major") !=-1){
            k = 1;
        }else if(input.indexOf("d major") !=-1){
            k = 2;
        }else if(input.indexOf("d# major") !=-1 || input.indexOf("eb major") !=-1){
            k = 3;
        }else if(input.indexOf("e major") !=-1){
            k = 4;
        }else if(input.indexOf("f major") !=-1 || input.indexOf("e# major") !=-1){
            k = 5;
        }else if(input.indexOf("f# major") !=-1 || input.indexOf("gb major") !=-1){
            k = 6;
        }else if(input.indexOf("g major") !=-1){
            k = 7;
        }else if(input.indexOf("g# major") !=-1 || input.indexOf("ab major") !=-1){
            k = 8;
        }else if(input.indexOf("a major") !=-1){
            k = 9;
        }else if(input.indexOf("a# major") !=-1 || input.indexOf("bb major") !=-1){
            k = 10;
        }else if(input.indexOf("b major") !=-1 || input.indexOf("cb major") !=-1){
            k = 11;
		// majors
            
        // natural minors
        
        }else if(input.indexOf("c natural minor") !=-1 || input.indexOf("b# natural minor") !=-1){
            m = -1;
        }else if(input.indexOf("c# natural minor") !=-1 || input.indexOf("db natural minor") !=-1){
            k = 1;
            m = -1;
		}else if(input.indexOf("d natural minor") !=-1){
            k = 2;
            m = -1;
		}else if(input.indexOf("d# natural minor") !=-1 || input.indexOf("eb natural minor") !=-1){
            k = 3;
            m = -1;
		}else if(input.indexOf("e natural minor") !=-1){
            k = 4;
            m = -1;
		}else if(input.indexOf("f natural minor") !=-1 || input.indexOf("e# natural minor") !=-1){
            k = 5;
            m = -1;
		}else if(input.indexOf("f# natural minor") !=-1 || input.indexOf("gb natural minor") !=-1){
            k = 6;
            m = -1;
		}else if(input.indexOf("g natural minor") !=-1){
            k = 7;
            m = -1;
		}else if(input.indexOf("g# natural minor") !=-1 || input.indexOf("ab natural minor") !=-1){
            k = 8;
            m = -1;
		}else if(input.indexOf("a natural minor") !=-1){
            k = 9;
            m = -1;
		}else if(input.indexOf("a# natural minor") !=-1 || input.indexOf("bb natural minor") !=-1){
            k = 10;
            m = -1;
		}else if(input.indexOf("b natural minor") !=-1 || input.indexOf("cb natural minor") !=-1){
            k = 11;
            m = -1;    
        //  harmonic minors
            
        }else if(input.indexOf("c harmonic minor") !=-1 || input.indexOf("b# harmonic minor") !=-1){
            m = -1;
            hm = 1;
        }else if(input.indexOf("c# harmonic minor") !=-1 || input.indexOf("db harmonic minor") !=-1){
            k = 1;
            m = -1;
			hm = 1;
		}else if(input.indexOf("d harmonic minor") !=-1){
            k = 2;
            m = -1;
			hm = 1;
		}else if(input.indexOf("d# harmonic minor") !=-1 || input.indexOf("eb harmonic minor") !=-1){
            k = 3;
            m = -1;
			hm = 1;
		}else if(input.indexOf("e harmonic minor") !=-1){
            k = 4;
            m = -1;
			hm = 1;
		}else if(input.indexOf("f harmonic minor") !=-1 || input.indexOf("e# harmonic minor") !=-1){
            k = 5;
            m = -1;
			hm = 1;
		}else if(input.indexOf("f# harmonic minor") !=-1 || input.indexOf("gb harmonic minor") !=-1){
            k = 6;
            m = -1;
			hm = 1;
		}else if(input.indexOf("g harmonic minor") !=-1){
            k = 7;
            m = -1;
			hm = 1;
		}else if(input.indexOf("g# harmonic minor") !=-1 || input.indexOf("ab harmonic minor") !=-1){
            k = 8;
            m = -1;
			hm = 1;
		}else if(input.indexOf("a harmonic minor") !=-1){
            k = 9;
            m = -1;
			hm = 1;
		}else if(input.indexOf("a# harmonic minor") !=-1 || input.indexOf("bb harmonic minor") !=-1){
            k = 10;
            m = -1;
			hm = 1;
		}else if(input.indexOf("b harmonic minor") !=-1 || input.indexOf("cb harmonic minor") !=-1){
            k = 11;
            m = -1;
			hm = 1;          
        // melodic minors
            
        }else if(input.indexOf("c melodic minor") !=-1 || input.indexOf("b# melodic minor") !=-1){
            m = -1;
            ml = 1;
        }else if(input.indexOf("c# melodic minor") !=-1 || input.indexOf("db melodic minor") !=-1){
            k = 1;
            m = -1;
			ml = 1;
		}else if(input.indexOf("d melodic minor") !=-1){
            k = 2;
            m = -1;
			ml = 1;
		}else if(input.indexOf("d# melodic minor") !=-1 || input.indexOf("eb melodic minor") !=-1){
            k = 3;
            m = -1;
			ml = 1;
		}else if(input.indexOf("e melodic minor") !=-1){
            k = 4;
            m = -1;
			ml = 1;
		}else if(input.indexOf("f melodic minor") !=-1 || input.indexOf("e# melodic minor") !=-1){
            k = 5;
            m = -1;
			ml = 1;
		}else if(input.indexOf("f# melodic minor") !=-1 || input.indexOf("gb melodic minor") !=-1){
            k = 6;
            m = -1;
			ml = 1;
		}else if(input.indexOf("g melodic minor") !=-1){
            k = 7;
            m = -1;
			ml = 1;
		}else if(input.indexOf("g# melodic minor") !=-1 || input.indexOf("ab melodic minor") !=-1){
            k = 8;
            m = -1;
			ml = 1;
		}else if(input.indexOf("a melodic minor") !=-1){
            k = 9;
            m = -1;
			ml = 1;
		}else if(input.indexOf("a# melodic minor") !=-1 || input.indexOf("bb melodic minor") !=-1){
            k = 10;
            m = -1;
			ml = 1;
		}else if(input.indexOf("b melodic minor") !=-1 || input.indexOf("cb melodic minor") !=-1){
            k = 11;
            m = -1;
			ml = 1;
        }else {
            System.out.println("The key you entered is invalid");
            System.exit(0);
		}
		// scales

        // executing scale 
		
		/* 4 (if used will glitch)
        note(c4 + k, e);
        Thread.sleep(e);
        note(d4 + k, s);
        Thread.sleep(s);
        note(e4 + k + m, s);
        Thread.sleep(s);
        note(f4 + k, s);
        Thread.sleep(s);
        note(g4 + k, s);
        Thread.sleep(s);
        note(a4 + k + m + ml, s);
        Thread.sleep(s);
        note(b4 + k + m + hm + ml, s);
        Thread.sleep(s);
		*/
		
        // 5
        note(c5 + k, s);
        Thread.sleep(s);
        note(d5 + k, s);
        Thread.sleep(s);
        note(e5 + k + m, s);
        Thread.sleep(s);
        note(f5 + k, s);
        Thread.sleep(s);
        note(g5 + k, s);
        Thread.sleep(s);
        note(a5 + k + m + ml, s);
        Thread.sleep(s);
        note(b5 + k + m + hm + ml, s);
        Thread.sleep(s);
        // 6
        note(c6 + k, s);
        Thread.sleep(s);
        note(d6 + k, s);
        Thread.sleep(s);
        note(e6 + k + m, s);
        Thread.sleep(s);
        note(f6 + k, s);
        Thread.sleep(s);
        note(g6 + k, s);
        Thread.sleep(s);
        note(a6 + k + m + ml, s);
        Thread.sleep(s);
        note(b6 + k + m + hm + ml, s);
        Thread.sleep(s);
        // 7
        note(c7 + k, s);
        Thread.sleep(s);
		// 6
        note(b6 + k + m + hm, s);
        Thread.sleep(s);
        note(a6 + k + m, s);
        Thread.sleep(s);
        note(g6 + k, s);
        Thread.sleep(s);
        note(f6 + k, s);
        Thread.sleep(s);
        note(e6 + k + m, s);
        Thread.sleep(s);
        note(d6 + k, s);
        Thread.sleep(s);
        note(c6 + k, s);
        Thread.sleep(s);
		// 5
        note(b5 + k + m + hm, s);
        Thread.sleep(s);
        note(a5 + k + m, s);
        Thread.sleep(s);
        note(g5 + k, s);
        Thread.sleep(s);
        note(f5 + k, s);
        Thread.sleep(s);
        note(e5 + k + m, s);
        Thread.sleep(s);
        note(d5 + k, s);
        Thread.sleep(s);
        note(c5 + k, q);
        Thread.sleep(q);
		
		 /* 4 (if used, will glitch)
        note(b4 + k + m + hm, s);
        Thread.sleep(s);
        note(a4 + k + m, s);
        Thread.sleep(s);
        note(g4 + k, s);
        Thread.sleep(s);
        note(f4 + k, s);
        Thread.sleep(s);
        note(e4 + k + m, s);
        Thread.sleep(s);
        note(d4 + k, s);
        Thread.sleep(s);
        note(c4 + k, h);
        Thread.sleep(h);
		*/
        
    } // main

    public static void note(int n, int l){
      try{
        /* Create a new Sythesizer and open it. Most of 
         * the methods you will want to use to expand on this 
         * example can be found in the Java documentation here: 
         * https://docs.oracle.com/javase/7/docs/api/javax/sound/midi/Synthesizer.html
         */
        Synthesizer midiSynth = MidiSystem.getSynthesizer(); 
        midiSynth.open();

        //get and load default instrument and channel lists
        Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
        MidiChannel[] mChannels = midiSynth.getChannels();

        midiSynth.loadInstrument(instr[0]);//load an instrument


        mChannels[0].noteOn(n, 100);//On channel 0, play note number 60 with velocity 100 
        try { 
            Thread.sleep(l); // wait time in milliseconds to control duration
        } catch( InterruptedException e ) { }
        
        mChannels[0].noteOff(5); //turn of the note


      } catch (MidiUnavailableException e) {}
    } // note

}  // Music