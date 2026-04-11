class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(String s, int start, List<String> current, List<String> result) {
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }
        
        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String part = s.substring(start, start + i);
            if (isValid(part)) {
                current.add(part);
                backtrack(s, start + i, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private boolean isValid(String part) {
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(part);
        return num >= 0 && num <= 255;
    }
}