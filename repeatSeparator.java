public String repeatSeparator(String word, String sep, int count) 
{
  String newStr = "";
  
  for(int i =0;i<count;i++)
  {
    if(i == count - 1)
    {
      newStr += word;
    }
    else
    {
      newStr += word + sep;
    }
    
  }
  
  return newStr;
}
