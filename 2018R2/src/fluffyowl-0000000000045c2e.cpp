#include <bits/stdc++.h>
using namespace std;
#define REP(i,n) for (int i=0;i<(n);i++)
#define REP2(i,m,n) for (int i=m;i<(n);i++)
typedef long long ll;
typedef long double ld;

int A[111];
int B[300][111];

void solve(int t) {
    memset(A, 0, sizeof(A));
    memset(B, 0, sizeof(B));
    int C;
    cin >> C;
    REP(i, C) cin >> A[i];

    int max_row = 1;

    if (A[0] == 0 || A[C-1] == 0) {
        cout << "Case #" << t << ": IMPOSSIBLE" << "\n";
        return;
    }

    for (int i = 0, p = 0; i < C; ++i) {
        while (p < C && A[p] == 0) ++p;
        if (i == p) {
            A[i] -= 1;
        } else if (p < i) {
            for (int j = i, r = 0; j > p; --j, ++r) {
                B[r][j] = 1;
                max_row = max(max_row, r+2);
            }
            A[p] -= 1;
        } else {
            for (int j = i, r = 0; j < p; ++j, ++r) {
                B[r][j] = 2;
                max_row = max(max_row, r+2);
            }
            A[p] -= 1;
        }
    }

    cout << "Case #" << t << ": " << max_row << "\n";
    REP(i, max_row) {
        REP(j, C) {
            if (B[i][j] == 0) cout << ".";
            else if (B[i][j] == 1) cout << "/";
            else cout << "\\";
        }
        cout << "\n";
    }
}

int main() {
    cin.tie(0);
    ios::sync_with_stdio(false);

    int T; cin >> T;
    REP(i, T) solve(i+1);
}
