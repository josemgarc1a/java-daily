import java.util.Map;

class SqueakyClean {

    private static final Map<Character, Character> LEET_SPEAK_MAP = 
                Map.of('4','a','3','e','0','o','1','l','7','t');  

    static String clean(String identifier) {
        if (identifier.isEmpty()) return identifier;
        
        StringBuilder output = new StringBuilder(identifier.length());
        boolean capitalizeNextChar = false;
        
        for(int i=0; i<identifier.length(); i++) {
            char ichar = identifier.charAt(i);
            
            if (capitalizeNextChar) {
                ichar=Character.toUpperCase(ichar); 
                capitalizeNextChar=false;
            }
            
            if (ichar == ' ') {
                output.append('_');
            }else if (ichar == '-') {
                capitalizeNextChar=true;
            }else if (Character.isDigit(ichar)) {
                output.append(LEET_SPEAK_MAP.get(ichar));
            }else if (Character.isLetter(ichar)) {
                output.append(ichar);
            }
        }
        return output.toString();
    }
}
