public String repeatEnd(String str, int n) 
{
  String endStr = "";
  for(int i = str.length() - n; i < str.length(); i++)
  {
    endStr += str.substring(i, i+1);
  }
  
  String loopedString = "";
  for(int i =0;i < n;i++)
  {
    loopedString += endStr;
  }
  
  return loopedString;
}
