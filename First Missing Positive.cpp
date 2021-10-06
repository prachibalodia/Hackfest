class Solution {
public:
    int firstMissingPositive(vector<int>& n)
    {
        unordered_map<int,int> m;
        
        for(int i=0;i<n.size();i++)
        m[n[i]]=1;
        
        for(int i=1; ;i++)
        {
            if(m.find(i)==m.end())
            return i;
        }
        return INT_MAX;
    }
};
